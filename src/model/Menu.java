package model;
import java.util.ArrayList;

public class Menu extends Product {

	private ArrayList<Product> menuItems = new ArrayList<Product>();
	public Menu(float price, String name, String type, int id) {
		super(price, name, type, id);
	}
	
	public void addItemToMenu(Product product) {
		menuItems.add(product);
	}

}
