package model;

public class Product {
	
	protected float price;
	protected String name;
	protected String type;
	
	public Product(float price, String name, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}
	
}
