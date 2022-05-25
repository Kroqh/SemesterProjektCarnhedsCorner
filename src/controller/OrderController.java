package controller;
import java.util.ArrayList;

import database.DataAccessException;
import database.IOrderDB;
import database.OrderDB;
import model.Order;
import model.OrderLine;
import model.Product;

public class OrderController {
	private Order currentOrder;
	private TableController tableController;
	private IOrderDB orderDB;
	
	public OrderController() {
		tableController = new TableController();
		orderDB = new OrderDB();
	}
	

	public void createOrder(int tableID) {
		currentOrder = new Order(tableID);
	}
	
	public void addProductToOrder(Product product, int quantity) throws NullPointerException {
		if (product == null) {
			throw new NullPointerException("det valgte produkt findes ikke");
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
	
	public void saveOrder(float payAmount) throws DataAccessException{
			currentOrder.setPaymentStatus(true);
			tableController.releaseTable(currentOrder.getTableID());
			orderDB.saveOrder(currentOrder);
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

	public void removeOrderLine(OrderLine orderLine) {
		currentOrder.removeOrderLine(orderLine);
	}
}	
