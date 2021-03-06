package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import dao.ProductDAO;
import tool.Action;

public class ProductUpdateAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//スタート
		System.out.println("ProductRemoveActionのスタート");
		//セッションの取得
		HttpSession session = request.getSession();
		System.out.println(session);
		//取得キーワード
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		int numberID = Integer.parseInt(id);
		int numberPrice = Integer.parseInt(price);

		//取得キーワード出力
		System.out.println(name);
		System.out.println(price);
		System.out.println(id);

		//フォームの値をbeanへ
		Product p = new Product();
		p.setId(numberID);
		p.setName(name);
		p.setPrice(numberPrice);

		//商品DAOのinsert実行
		ProductDAO dao = new ProductDAO();
		System.out.println(dao);

		int line = dao.Update(p);
		//もし追加されたら
		if (line > 0) {
		}
		//リターン
		return "../jsp/item-manage.jsp";
	}
}
