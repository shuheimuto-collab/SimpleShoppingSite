package servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import bean.Product;
import tool.Action;

public class CartAddAction extends Action {

	@SuppressWarnings("unchecked")
	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//スタート
		System.out.println("CartAddActionスタート");

		//セッションスコープのの取得
		HttpSession session = request.getSession();

		//商品IDの取得
		int id;
		String stID = request.getParameter("id");
		id = Integer.parseInt(stID);
		System.out.println(id);

		//商品数の取得
		int number;
		String stNumber = request.getParameter("number");
		number = Integer.parseInt(stNumber);
		System.out.println(number);

		//セッションスコープからcartを取り出す
		List<Item> cart = (List<Item>) session.getAttribute("cart");
		//カートが空なら
		if (cart == null) {
			//カート作成
			cart = new ArrayList<Item>();
			//カートセット
			session.setAttribute("cart", cart);
		}

		//追加する商品がカートの中にあったら、個数を変更してカートへ
		for (Item i : cart) {
			if (i.getProduct().getId() == id) {
				//カートの個数を変更
				i.setCount(i.getCount() + number);
				return "../jsp/cart.jsp";
			}
		}

		//追加する商品がカートの中になかったら、
		List<Product> list = (List<Product>) session.getAttribute("list");//listは商品一覧(Product)取得
		//listの中の商品の回数分ループ
		for (Product p : list) {
			if (p.getId() == id) {
				Item i = new Item();//Bean作成
				i.setProduct(p);//Productインスタンスをセット
				i.setCount(number);//Productの個数をセット
				cart.add(i);//カートにアイテムを追加
			}
		}
		return "../jsp/cart.jsp";
	}
}
