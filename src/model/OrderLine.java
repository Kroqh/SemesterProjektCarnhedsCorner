package model;

public class OrderLine {
	private int quantity;
	private Product product;
	
	public OrderLine(int quantity, Product product) {
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
