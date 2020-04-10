package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import dao.PurchaseDAO;
import tool.Action;

public class PurchaseAction extends Action {
	@SuppressWarnings("unchecked")
	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//スタート
		System.out.println("PurchaseActionのスタート");
		//セッションスコープの取得
		HttpSession session = request.getSession();
		//リクエストスコープの取得
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		System.out.println("nameは" + name);
		System.out.println("addressは" + address);
		//どちらも空だったら
		if (name.isEmpty() || address.isEmpty()) {
			System.out.println("purchase-error-empty.jspへ");
			return "../jsp/purchase-error-empty.jsp";
		}
		//空ではなかったらDAO作成
		System.out.println("PurchaseDAO作成");
		PurchaseDAO dao = new PurchaseDAO();
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		System.out.println(cart);
		//daoのinsertメソッドの実行
		boolean bl = dao.insert(cart, name, address);
		System.out.println(bl);
		//どちらかがtrueの場合
		//cartが空か!blがtrueの時
		if (cart == null || !bl) {
			System.out.println("purchase-error-insert.jspへ");
			return "../jsp/purchase-error-insert.jsp";
		}
		//セッションスコープから削除
		session.removeAttribute("cart");
		//購入手続き完了ページ
		return "../jsp/purchase-out.jsp";
	}
}
