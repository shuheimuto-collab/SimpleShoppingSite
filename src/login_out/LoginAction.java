package login_out;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Customer;
import dao.CustomerDAO;
import tool.Action;

public class LoginAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		System.out.println("loginActionのスタート ");
		//セッションの取得
		HttpSession session=request.getSession();
		System.out.println("sessionは" + session);
		//ログイン情報を格納と出力
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		System.out.println("loginは " + login);
		System.out.println("passwordは" + password);
		//DAOの作成
		CustomerDAO dao=new CustomerDAO();
		System.out.println(dao);
		//顧客検索実行
		Customer customer=null;
		customer = dao.search(login, password);
		System.out.println(customer);
		//空ではなかったら
		if (customer!=null) {
			//セッションに保存
			session.setAttribute("customer", customer);
			Customer getCustomer = (Customer) session.getAttribute("customer");
			System.out.println(getCustomer.getId());
			//管理者チェック
			if(getCustomer.getId() ==6) {
				//管理者画面へ
				return "../jsp/item-manage.jsp";
			}
			//ログイン成功画面へ
			return "../jsp/product.jsp";
		}
		//ログイン失敗画面へ
		return "../jsp_login_out/login-error.jsp";
	}
}
