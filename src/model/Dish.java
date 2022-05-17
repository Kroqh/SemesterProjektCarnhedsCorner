package model;

public class Dish extends Product {

	private boolean isVegetarian;
	private String dishType;
	
	public Dish(float price, String name, String type, boolean isVegetarian, String dishType, int id) {
		super(price, name, type, id);
		this.isVegetarian = isVegetarian;
		this.dishType = dishType;
	}

}
