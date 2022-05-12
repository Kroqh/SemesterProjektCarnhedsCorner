package model;
import java.util.ArrayList;

public class Menu extends Product {

	private ArrayList<Product> menuItem = new ArrayList<Product>();
	public Menu(float price, String name, String type) {
		super(price, name, type);
	}
	
	public void addItemToMenu(Product product) {
		menuItem.add(product);
	}

}