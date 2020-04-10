package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import dao.ProductDAO;
import tool.Action;

public class ProductInsertAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		//スタート
		System.out.println("ProductInsertActionのスタート");
		//セッションの取得
		HttpSession session=request.getSession();
		System.out.println(session);
		//取得ID
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		int numberPrice=Integer.parseInt(price);
		//フォームの値をbeanへ
		Product p=new Product();
		p.setName(name);
		p.setPrice(numberPrice);
		//商品DAOのinsert実行
		ProductDAO dao=new ProductDAO();
		int line=dao.insert(p);
		//もし追加されたら
		if (line>0) {
		}
		//エンド
		System.out.println("ProductInsertActionのエンド");
		//リターン
		return "../jsp/item-manage.jsp";
		}
}
