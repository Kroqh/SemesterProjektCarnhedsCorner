package model;

public class Dish extends Product {

	private boolean isVegetarian;
	
	public Dish(float price, String name, String type, boolean isVegetarian, int id) {
		super(price, name, type, id);
		this.isVegetarian = isVegetarian;
	}

}
