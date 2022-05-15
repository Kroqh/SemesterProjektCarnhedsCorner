package model;

public class OrderLine {
	private int quantity;
	private Product product;
	
	public OrderLine(Product product, int quantity) {
		this.quantity = quantity;
		this.product = product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public Product getProduct() {
		return product;
	}
	
	public int getProductID() {
		return product.getID();
	}
}
