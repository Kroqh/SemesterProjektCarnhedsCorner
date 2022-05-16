package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Dish;
import model.Drink;
import model.Ingredient;
import model.Menu;
import model.Product;

public class ProductDB {

	public Product getProductByID(int id) throws DataAccessException, SQLException {
		Connection con = DBConnection.getInstance().getConnection();
		Product product = null;
		String baseSelect = "select name, type, price from CHC_Products ";
		baseSelect += "left outer join CHC_Dishes on CHC_Products.id = CHC_Dishes.fk_ProductID ";
		baseSelect += "left outer join CHC_Ingredients on CHC_Products.id = CHC_Ingredients.fk_ProductID ";
		baseSelect += "left outer join CHC_Drinks on CHC_Products.id = CHC_Drinks.fk_ProductID ";
		baseSelect += "Where id = ?;";
		
		ResultSet rs = null;
		String name = null;
		String type = null;
		float price = 0;
		
		try {
			PreparedStatement stmt = con.prepareStatement(baseSelect);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			rs.next();
			name = rs.getString("name");
			type = rs.getString("type");
			price = rs.getFloat("price");
			
			switch (type) {
			case "menu":
				product = new Menu(price, name, type, id);
				break;
			case "dish":
				boolean vegetarian = rs.getBoolean("vegetarian");
				product = new Dish(price, name, type, vegetarian, id);
				break;
			case "ingredient":
				product = new Ingredient(price, name, type, id);
				break;
			case "drink":
				float alcPercent = rs.getFloat("alcPercent");
				product = new Drink(price, name, type, alcPercent, id);
				break;
			}
			stmt.close();
			con.commit();
		} catch (SQLException e) {
			throw e;
		}
		return product;
	}

	public ArrayList<Product> findAllProductsByType(String type) throws SQLException, DataAccessException {
		Connection con = DBConnection.getInstance().getConnection();
		ArrayList<Product> products = new ArrayList<>();
		Product product = null;
		String baseSelect = "select * from CHC_Products ";
		baseSelect += "left outer join CHC_Dishes on CHC_Products.id = CHC_Dishes.fk_ProductID ";
		baseSelect += "left outer join CHC_Ingredients on CHC_Products.id = CHC_Ingredients.fk_ProductID ";
		baseSelect += "left outer join CHC_Drinks on CHC_Products.id = CHC_Drinks.fk_ProductID ";
		baseSelect += "where type = ?";
		
		ResultSet rs = null;
		String name = null;
		float price = 0;
		int id = 0;
		
		try {
			PreparedStatement stmt = con.prepareStatement(baseSelect);
			stmt.setString(1, type);
			rs = stmt.executeQuery();
			while(rs.next()) {
				name = rs.getString("name");
				price = rs.getFloat("price");
				id = rs.getInt(id);
				
				switch (type) {
				case "menu":
					product = new Menu(price, name, type, id);
					break;
				case "dish":
					boolean vegetarian = rs.getBoolean("vegetarian");
					product = new Dish(price, name, type, vegetarian, id);
					break;
				case "ingredient":
					product = new Ingredient(price, name, type, id);
					break;
				case "drink":
					float alcPercent = rs.getFloat("alcPercent");
					product = new Drink(price, name, type, alcPercent, id);
					break;
				}
				products.add(product);
			}
			stmt.close();
			con.commit();
		} catch (SQLException e) {
			throw e;
		}
		return products;
	}
}
