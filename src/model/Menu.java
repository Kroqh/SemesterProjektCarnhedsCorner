package model;
import java.util.ArrayList;

public class Menu extends Product {

	private ArrayList<Product> menuItems = new ArrayList<Product>();
	private Drink drink;
	
	public Menu(float price, String name, String type, int id) {
		super(price, name, type, id);
		this.name = "menu";
	}
	
	public void addItemToMenu(Product product) {
		menuItems.add(product);
	}
	
	public void addDrinkToMenu(Drink drink) {
		this.drink = drink;
	}
	
	public Drink getDrink() {
		return drink;
	}

	public int getDrinkID() {
		return drink.getID();
	}
}
	