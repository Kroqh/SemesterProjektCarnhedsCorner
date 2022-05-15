package model;

public class Drink extends Product {

	private float alcoholPercent;
	
	public Drink(float price, String name, String type, float alcoholPercent, int id) {
		super(price, name, type, id);
		this.alcoholPercent = alcoholPercent;
	}

}
