package controller;

import java.util.ArrayList;

import model.Order;
import model.Table;
import model.TableContainer;

public class TableController {
	private TableContainer tableContainer;
	
	public TableController() {
		this.tableContainer = TableContainer.getInstance();
	}

	public Table selectTable(int tableID) throws NullPointerException {
		Table table = TableContainer.getInstance().findTableByID(tableID);
		
		if (table == null) {
			throw new NullPointerException("Table out of range");
		}
		
		return table;
	}
	public void releaseTable(int tableID) {
		tableContainer.setOrderToTable(tableID, null);
	}
	
	public ArrayList<Table> getTables() {
		return tableContainer.getTables();
	}

	public Order getOrderFromTable(int tableID) {
		return tableContainer.findTableByID(tableID).getCurrentOrder();
	}
	public void setOrderToTable(int tableID, Order order) {
		tableContainer.setOrderToTable(tableID, order);
	}
	
	public ArrayList<Table> getActiveTables() {
		ArrayList<Table> activeTables = tableContainer.getActiveTables();
		return activeTables;
	}

	public ArrayList<Table> getInactiveTables() {
		return tableContainer.getInactiveTables();
	}
	
}
