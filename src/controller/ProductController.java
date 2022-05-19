package controller;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;

import database.DataAccessException;
import database.ProductDB;

public class ProductController {
	
	private ProductDB productDB;
	
	public ProductController() {
		productDB = new ProductDB();
	}

	public Product findProductByID(int productID) throws Exception {
		return productDB.getProductByID(productID);
	}

	public ArrayList<Product> findAllProductsByType(String type) throws SQLException, DataAccessException {
		ArrayList<Product> products = null;
		if (type == "appetizer" || type == "forret" || type == "hovedret" || type == "dessert/ost") {
			products = productDB.findAllDishesOfType(type);
		}
		else if (type == "mousserende vin" || type == "rosévin" || type == "hvidvin" || type == "rødvin" || type == "øl" || type == "sodavand" || type == "thy øko saft" || type == "varme drikke" || type == "dessertvin og avec") {
			products = productDB.findAllDrinkOfType(type);
		}
		else {
			products = productDB.findAllProductsByType(type);
		}
		return products;
	}
}
