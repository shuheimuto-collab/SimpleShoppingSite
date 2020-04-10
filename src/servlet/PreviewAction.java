package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import tool.Action;

public class PreviewAction extends Action {
	@SuppressWarnings("unchecked")
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		//スタート
		System.out.println("PreviewActionのスタート");
		//セッションの取得
		HttpSession session=request.getSession();
		//セッションの表示
		System.out.println("セッションの中身は" + session);
		//セッションの中身を出力
		Object s = session.getAttribute("customer");//キャスト
		System.out.println("セッションの中身は" +s);
		//ログインチェック
		if (s==null) {
			System.out.println("preview-error-login.jspへ");
			return "../jsp/preview-error-login.jsp";
		}
		//セッションの中身を取得
		System.out.println("セッションの中身を取得");
		List<Item> cart=(List<Item>) session.getAttribute("cart");
		//セッションの中身を出力
		System.out.println(cart);
		//セッションの比較
		//または
		if (cart==null || cart.size()==0) {
			System.out.println("preview-error-cart.jspへ");
			return "../jsp/preview-error-cart.jsp";
		}
		System.out.println("purchase-in.jspへ");
		return "../jsp/purchase-in.jsp";
	}
}
