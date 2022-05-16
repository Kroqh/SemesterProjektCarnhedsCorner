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
		return productDB.findAllProductsByType(type);
	}
}
