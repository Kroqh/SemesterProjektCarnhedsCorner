package model;
import java.util.ArrayList;

public class Ingredient extends Product {
	private ArrayList<IngredientQuantity> ingredientQuantities = new ArrayList<IngredientQuantity>();

	public Ingredient(float price, String name, String type) {
		super(price, name, type);
	}
	
	

}
