package tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"*.action"})
public class FrontController extends HttpServlet {

	public void doPost(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		System.out.println(out);
		System.out.println("requestインスタンス" + request);
		System.out.println("responseインスタンス" + response);
		try {
			System.out.println("FrontController_doPostのスタート");
			//substringは先頭の一文字除去(/)
			System.out.println("FrontController1");
			String path=request.getServletPath().substring(1);
			//パスの取得
			System.out.println("request.getServletPath()  =  " + request.getServletPath());
			System.out.println("path  =  " + path);
			//置換
			String name=path.replace(".a", "A").replace('/', '.');
			System.out.println("name  =  " + name);
			//アクションの生成
			System.out.println("FrontController2");
			Action action=(Action)Class.forName(name).newInstance();
			//アクションの実行とフォワード先URL
			System.out.println("FrontController3");
			String url=action.execute(request, response);
			System.out.println(url);
			//アクション実行後にフォワード
			System.out.println("FrontController4");
			request.getRequestDispatcher(url).
				forward(request, response);
			//エンド
			System.out.println("FrontController_doPostのエンド");
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}

	//メニュークリックするとここからスタート
	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		System.out.println("FrontController_doGetのスタート");
		System.out.println(request);
		System.out.println(response);
		//doPost処理へ
		doPost(request, response);
		System.out.println("FrontController_doGetのエンド");
	}
}
