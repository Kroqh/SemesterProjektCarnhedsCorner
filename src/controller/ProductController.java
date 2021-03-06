package controller;
import model.Menu;
import model.Order;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;

import database.DataAccessException;
import database.IProductDB;
import database.ProductDB;

public class ProductController {
	
	private IProductDB productDB;
	private ArrayList<Product> tempProducts;
	private OrderController orderController;
	
	public ProductController() {
		productDB = new ProductDB();
		tempProducts = new ArrayList<>();
		orderController = new OrderController();
	}

	public Product findProductByID(int productID) throws ProductNotFoundException, DataAccessException {
		Product product = null;
		try {
			product = productDB.getProductByID(productID);
		} catch (SQLException e) {
			throw new ProductNotFoundException("Der kunne ikke findes nogle produkter med det fundne produktID");
		}
		return product;
	}

	public ArrayList<Product> findAllProductsByType(String type) throws DataAccessException, ProductNotFoundException {
		ArrayList<Product> products = null;
		try {
			if (type == "appetizer" || type == "forret" || type == "hovedret" || type == "dessert/ost") {
				products = productDB.findAllDishesOfType(type);
			}
			else if (type == "mousserende vin" || type == "rosévin" || type == "hvidvin" || type == "rødvin" || type == "øl" || type == "sodavand" || type == "thy øko saft" || type == "varme drikke" || type == "dessertvin og avec") {
				products = productDB.findAllDrinkOfType(type);
			}
			else {
				products = productDB.findAllProductsByType(type);
			}
		} catch (SQLException e) {
			throw new ProductNotFoundException("Der kunne ikke findes nogle produkter af den valgte type");
		}
		return products;
	}

	public Menu create3DishMenu(float price, String dishName1, String dishName2, String dishName3) {
		if( price == 0) {
			price = 350;
		}
		Product dish1 = getProductFromTempListByName(dishName1);
		Product dish2 = getProductFromTempListByName(dishName2);
		Product dish3 = getProductFromTempListByName(dishName3);
		Menu menu = new Menu(price, null, "menu", 0);
		menu.addItemToMenu(dish1);
		menu.addItemToMenu(dish2);
		menu.addItemToMenu(dish3);
		return menu;
	}
	
	public void addProductToTempList(Product product) {
		tempProducts.add(product);
	}
	
	public Product getProductFromTempListByName(String productName) {
		Product product = null;
		boolean found = false;
		int index = 0;
		while(!found && index < tempProducts.size()) {
			product = tempProducts.get(index);
			if (product.getName().equals(productName)) {
				found = true;
			} else {
				index++;
			}
		}
		return product;
	}

	public void saveMenu(Product menu) throws Exception {
		try {
			productDB.saveMenuProduct(menu);
		} catch (SQLException e) {
			throw new Exception("Kunne ikke gemme menuen på databasen, prøv igen");
		}
	}

	public void setCurrentOrder(Order order) {
		orderController.setCurrentOrder(order);
		
	}

	public void addProductToOrder(int productID, int quantity) throws ProductNotFoundException, DataAccessException, NullPointerException {
		Product product = null;
		product = findProductByID(productID);
		orderController.addProductToOrder(product, quantity);
	}

	public void addMenuToOrder(Product menu) {
		orderController.addMenuToOrder(menu);
	}
}
