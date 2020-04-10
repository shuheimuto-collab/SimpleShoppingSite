package login_out;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		//開始
		System.out.println("logoutActionのスタート ");
		//セッションスコープ取得
		HttpSession session=request.getSession();
		//セッションスコープが空ではなかったら、空にする
		if (session.getAttribute("customer")!=null) {
			//セッションスコープ出力
			System.out.println(session.getAttribute("customer"));
			//インスタンス削除
			session.removeAttribute("customer");
			//終了
			return "../jsp_login_out/login-in.jsp";
		}
		//終了
		return "../jsp_login_out/login-in.jsp";
	}
}
