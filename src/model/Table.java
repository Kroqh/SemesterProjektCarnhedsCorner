package model;

public class Table {

	private int tableID;
	private Order currentOrder;
	private boolean isActive;
	
	public void setCurrentOrder(Order order) {
		currentOrder = order;
		isActive = false;
	}
	public Order getCurrentOrder() {
		return currentOrder;
	}
	
	public Table(int tableID) {
		this.tableID = tableID;
	}
	public int getTableID() {
		return tableID;
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setIsActive(boolean active) {
		this.isActive = active;
	}
}
