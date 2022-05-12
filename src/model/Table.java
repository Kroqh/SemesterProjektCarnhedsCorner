package model;

public class Table {

	private int tableID;
	private boolean active;
	private Order currentOrder;
	
	public void setCurrentOrder(Order order) {
		currentOrder = order;
	}
	public Order getCurrentOrder() {
		return currentOrder;
	}
	
}
