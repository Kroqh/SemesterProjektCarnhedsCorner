package controller;
import model.Product;
import database.ProductDB;

public class ProductController {
	
	private ProductDB productDB;
	
	public ProductController() {
		productDB = new ProductDB();
	}

	public Product findProductByID(int productID) throws Exception {
		return productDB.getProductByID(productID);
	}
}
