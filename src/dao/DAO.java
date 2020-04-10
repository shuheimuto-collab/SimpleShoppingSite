package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

public class DAO {
	static DataSource ds;
	Connection conn = null;// コネクション(プログラムとデータベースをつなげる)
	//DAOの共通処理
	//
	public Connection getConnection() throws Exception {
		System.out.println("getConnectionのスタート");
		// JDBCドライバの準備&ロード
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println(Class.forName("com.mysql.jdbc.Driver"));
		if (ds == null) {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/database", "root", "");
			//InitialContext ic = new InitialContext();
			//ds = (DataSource) ic.lookup("jdbc:mysql://localhost/database");
		}
		//Connection c = ds.getConnection();
		System.out.println(conn);
		System.out.println("getConnectionのエンド");
		return conn;
	}
}
