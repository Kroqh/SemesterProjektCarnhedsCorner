package model;

public class Dish extends Product {

	private boolean isVegetarian;
	
	public Dish(float price, String name, String type, boolean isVegetarian) {
		super(price, name, type);
		this.isVegetarian = isVegetarian;
	}

}
