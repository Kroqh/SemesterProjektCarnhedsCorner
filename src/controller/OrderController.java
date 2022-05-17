package controller;
import java.util.ArrayList;

import database.DataAccessException;
import database.OrderDB;
import model.Order;
import model.OrderLine;
import model.Product;

public class OrderController {
	private Order currentOrder;
	private TableController tableController;
	private ProductController productController;
	private OrderDB orderDB;
	
	public OrderController() {
		tableController = new TableController();
		productController = new ProductController();
		orderDB = new OrderDB();
	}
	
	public void createOrder(int tableID) {
		currentOrder = new Order(tableController.selectTable(tableID,currentOrder));
	}
	
	public void addProductToOrder(int productID, int quantity) throws Exception {
		Product product = productController.findProductByID(productID);
		if (product == null) {
			throw new NullPointerException("Product null???");
		}
		currentOrder.addOrderLine(product, quantity);
	}
	public void saveOrder(float payAmount) throws DataAccessException, InsufficientPaymentException {
		if (payAmount >= currentOrder.getTotalPrice()) {
			currentOrder.setPaymentStatus(true);
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
}	
