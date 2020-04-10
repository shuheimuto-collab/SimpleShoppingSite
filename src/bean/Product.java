package bean;

//Serializable
public class Product implements java.io.Serializable {

	private int id;//ID情報
	private String name;//商品名
	private int price;//商品の値段
	private String type;//商品区分
	private String detail;//詳細

	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getType() {
		return type;
	}
	public String getDetail() {
		return detail;
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public void setType(String type) {
		this.type=type;
	}
	public void setDetail(String detail) {
		this.detail=detail;
	}
}
