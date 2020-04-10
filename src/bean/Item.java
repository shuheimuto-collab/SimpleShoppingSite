package bean;

public class Item implements java.io.Serializable {

	private Product product;//Productインスタンス
	private int count;//個数

	public Product getProduct() {
		return product;
	}
	public int getCount() {
		return count;
	}

	public void setProduct(Product product) {
		this.product=product;
	}
	public void setCount(int count) {
		this.count=count;
	}
}
