package model;

public class Table {

	private int tableID;
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
	public void setInactive() {
		currentOrder = null;
	}
}
