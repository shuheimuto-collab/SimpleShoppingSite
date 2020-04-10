package bean;

public class Customer implements java.io.Serializable {

	private int id;//ID情報
	private String login;//ログイン
	private String password;//パスワード

	public int getId() {
		return id;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}

	public void setId(int id) {
		this.id=id;
	}
	public void setLogin(String login) {
		this.login=login;
	}
	public void setPassword(String password) {
		this.password=password;
	}
}
