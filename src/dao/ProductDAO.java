package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

public class ProductDAO extends DAO {

	//検索機能(共通機能)//
	public List<Product> search(String keyword) throws Exception {
		//スタート
		System.out.println("ProductDAOのsearchをスタート");
		//オブジェクトを入れる用のリスト
		System.out.println("1");
		List<Product> list = new ArrayList<>();
		System.out.println("listの中身は " + list);
		//データベースの接続
		System.out.println("2");
		Connection con = getConnection();
		//SQLの実行
		System.out.println("3");
		PreparedStatement st = con.prepareStatement(
				"select * from product where name like ?");
		st.setString(1, "%" + keyword + "%");
		ResultSet rs = st.executeQuery();
		//ResultSetオブジェクトから1個ずつ取り出す
		System.out.println("4");
		while (rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			p.setType(rs.getString("type"));
			p.setDetail(rs.getString("detail"));
			list.add(p);
		}
		//データベースの切断
		System.out.println("5");
		st.close();
		con.close();
		//エンド
		System.out.println("ProductDAOのSearchをエンド");
		return list;
	}

	////////////////////////////////////////////////////////////////////////////////////

	//追加機能(管理画面用)
	public int insert(Product product) throws Exception {
		Connection con = getConnection();
		//insert文の作成
		PreparedStatement st = con.prepareStatement(
				"insert into product values(null, ?,?,?,?)");
		//SQL文の置き替え
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		st.setString(3, "type");
		st.setString(4, "detail");
		//SQLの実行
		int line = st.executeUpdate();
		st.close();
		con.close();
		return line;
	}

	//削除機能(管理画面用)
	public int delete(int id) throws Exception {
		Connection con = getConnection();
		//insert文の作成
		PreparedStatement st = con.prepareStatement(
				"delete from product where id = ? ");
		//SQL文の置き替え
		st.setInt(1, id);		//SQLの実行
		int line = st.executeUpdate();
		st.close();
		con.close();
		return line;
	}

	//更新機能(管理画面用) *不完全
	public int Update(Product product) throws Exception {
		Connection con = getConnection();
		//insert文の作成
		PreparedStatement st = con.prepareStatement(
				"insert into product values(null, ?,?,?,?)");
		//SQL文の置き替え
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		st.setString(3, "type");
		st.setString(4, "detail");
		//SQLの実行
		int line = st.executeUpdate();
		st.close();
		con.close();
		return line;
	}
}
