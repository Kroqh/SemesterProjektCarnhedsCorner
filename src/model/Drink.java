package model;

public class Drink extends Product {

	private float alcoholPercent;
	
	public Drink(float price, String name, String type, float alcoholPercent) {
		super(price, name, type);
		this.alcoholPercent = alcoholPercent;
	}

}
