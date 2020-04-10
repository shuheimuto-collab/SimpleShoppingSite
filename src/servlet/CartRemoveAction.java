package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import tool.Action;

//カートから商品を削除
public class CartRemoveAction extends Action {
	@SuppressWarnings("unchecked")
	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CartRemoveActionのスタート");
		//セッションスコープの取得
		HttpSession session = request.getSession();
		//idの取得
		String stId = request.getParameter("id");
		System.out.println(stId);
		//idのint変換
		int id = Integer.parseInt(stId);
		System.out.println(id);
		//削除個数
		String stNumber = request.getParameter("number");
		//削除個数のint変換
		int number = Integer.parseInt(stNumber);
		System.out.println(number);
		//セッションスコープのカートを取得
		List<Item> cart = (List<Item>) session.getAttribute("cart");

		//カートからitemを取り出す
		for (Item item : cart) {
			if (item.getProduct().getId() == id) {
				//アイテムの個数がゼロだったら、、
				if (item.getCount() == 1) {
					cart.remove(item);
					break;
					//アイテムの個数がゼロ以上だったら、
				} else if (item.getCount() > 1) {
					item.setCount(item.getCount() - number);
					break;
				}
			}
		}
		return "../jsp/cart.jsp";
	}
}
