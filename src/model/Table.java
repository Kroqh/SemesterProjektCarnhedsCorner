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
	
	public Table(int tableID) {
		this.tableID = tableID;
	}
	public int getTableID() {
		return tableID;
	}
	public void setActive(Order order) {
		active = true;
		currentOrder = order;
	}
	public void setInactive() {
		active = false;
		currentOrder = null;
	}
}
