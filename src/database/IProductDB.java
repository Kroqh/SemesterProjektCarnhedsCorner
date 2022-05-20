package database;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Product;

public interface IProductDB {
	
	public Product getProductByID(int id) throws DataAccessException, SQLException;
	public ArrayList<Product> findAllProductsByType(String type) throws SQLException, DataAccessException;
	public ArrayList<Product> findAllDishesOfType(String dishType) throws DataAccessException, SQLException;
	public ArrayList<Product> findAllDrinkOfType(String drinkType) throws DataAccessException, SQLException;
	public void saveMenuProduct(Product menu) throws DataAccessException, SQLException;
}
