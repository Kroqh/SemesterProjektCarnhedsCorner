package model;

public class Drink extends Product {

	private float alcoholPercent;
	private String drinkType;
	
	public Drink(float price, String name, String type, float alcoholPercent, String drinkType, int id) {
		super(price, name, type, id);
		this.alcoholPercent = alcoholPercent;
		this.drinkType = drinkType;
	}

}
