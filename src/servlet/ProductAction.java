package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import dao.ProductDAO;
import tool.Action;

public class ProductAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		//スタート
		System.out.println("ProductActionのスタート");
		//セッションの取得
		HttpSession session=request.getSession();
		System.out.println(session);
		//検索キーワードの取得
		String keyword=request.getParameter("keyword");
		System.out.println(keyword);
		//検索キーワードが入っていない場合
		if (keyword==null) keyword="";
		//DAOクラス生成
		ProductDAO dao=new ProductDAO();
		System.out.println(dao);
		//DAOの検索機能を実行
		List<Product> list=dao.search(keyword);
		System.out.println(list);
		//セッションに格納
		session.setAttribute("list", list);
		//エンド
		System.out.println("ProductActionのエンド");
		//リターン
		return "../jsp/product.jsp";
		}
}
