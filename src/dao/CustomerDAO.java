package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Customer;

public class CustomerDAO extends DAO {
	public Customer search(String login, String password)
		throws Exception {
		System.out.println("CustomerDAOスタート");
		//beanの初期化
		Customer customer=null;
		System.out.println("DAO.javaへ");
		Connection con=getConnection();
		PreparedStatement st = null;
		st=con.prepareStatement(
			"select * from customer where login=? and password=?");
		System.out.println("stは" + st);
		st.setString(1, login);
		st.setString(2, password);
		System.out.println("stは" + st);
		ResultSet rs=st.executeQuery();
		System.out.println(rs);

		while (rs.next()) {
			//bean生成
			customer=new Customer();
			//beanに値を入れる
			customer.setId(rs.getInt("id"));
			System.out.println("IDは" + customer.getId());
			customer.setLogin(rs.getString("login"));
			System.out.println("loginは" + customer.getLogin());
			customer.setPassword(rs.getString("password"));
			System.out.println("passwordは" + customer.getPassword());
		}
		System.out.println("stクローズ");
		st.close();
		System.out.println("conクローズ");
		con.close();
		System.out.println("CustomerDAOエンド");
		return customer;
	}
}
