package controller;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DataAccessException;
import database.IOrderDB;
import database.OrderDB;
import model.Order;
import model.OrderLine;
import model.Product;
import model.Table;
import model.Menu;

public class OrderController {
	private Order currentOrder;
	private TableController tableController;
	private ProductController productController;
	private IOrderDB orderDB;
	
	public OrderController() {
		tableController = new TableController();
		productController = new ProductController();
		orderDB = new OrderDB();
	}
	

	public void createOrder(int tableID) {
		currentOrder = new Order(tableID);
	}
	
	public void addProductToOrder(int productID, int quantity) throws Exception {
		Product product = productController.findProductByID(productID);
		if (product == null) {
			throw new NullPointerException("Product null???");
		}
		currentOrder.addOrderLine(product, quantity);
	}
	
	public void switchCurrentOrder(int tableID) {
		Order order = tableController.getOrderFromTable(tableID);
		if (order == null) {
			throw new NullPointerException("No order exists on table");
		}
		else {
			currentOrder = order;
		}
		
	}
	
	public void addMenuToOrder(Product menu) {
		currentOrder.addOrderLine(menu, 1);
	}
	public void saveOrder(float payAmount) throws DataAccessException, InsufficientPaymentException {
		if (payAmount >= currentOrder.getTotalPrice()) {
			currentOrder.setPaymentStatus(true);
			tableController.releaseTable(currentOrder.getTableID());
			orderDB.saveOrder(currentOrder);
		}
		else {
			throw new InsufficientPaymentException("Insufficient payment");
		}
	}
	
	public Order getCurrentOrder() {
		return currentOrder;
	}
	
	public void setCurrentOrder(Order order) {
		currentOrder = order;
	}
	
	public ArrayList<OrderLine> getOrderLines() {
		return currentOrder.getOrderLines();
	}
	
	public float getTotalPrice() {
		return currentOrder.getTotalPrice();
	}
	
	public void setOrderToTable(int tableID, Order order) {
		tableController.setOrderToTable(tableID, order);
	}


	public ArrayList<Product> findAllProductsByType(String type) throws DataAccessException {
		ArrayList<Product> products = null;
		try {
			products = productController.findAllProductsByType(type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return products;
	}
}	
