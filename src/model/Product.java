package model;

public class Product {
	
	protected float price;
	protected String name;
	protected String type;
	protected int id;
	
	public Product(float price, String name, String type, int id) {
		this.name = name;
		this.price = price;
		this.type = type;
		this.id = id;
	}
	
	public int getID() {
		return id;
	}
	public float getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}

	public void setID(int insertedKeys) {
		this.id = insertedKeys;
	}	
}
