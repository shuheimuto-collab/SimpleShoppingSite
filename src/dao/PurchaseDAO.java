package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import bean.Item;
import bean.Product;

public class PurchaseDAO extends DAO {
	//insertメソッド
	public boolean insert(List<Item> cart, String name, String address) throws Exception {
		System.out.println("insert処理のスタート");
		//親メソッド(データベース接続)
		Connection con = null;
		con = getConnection();
		con.setAutoCommit(false);

		for (Item item : cart) {
			//データベース処理
			PreparedStatement st=con.prepareStatement(
				"insert into purchase values(null, ?, ?, ?, ?, ?, ?)");
			Product p = null;
			p = item.getProduct();
			st.setInt(1, p.getId());
			st.setString(2, p.getName());
			st.setInt(3, p.getPrice());
			st.setInt(4, item.getCount());
			st.setString(5, name);
			st.setString(6, address);
			//更新作業
			int line=st.executeUpdate();
			st.close();

			//1が返ってこなかったら、
			if (line!=1) {
				con.rollback();
				con.setAutoCommit(true);
				con.close();
				return false;
			}
		}

		con.commit();
		con.setAutoCommit(true);
		con.close();
		return true;
	}
}
