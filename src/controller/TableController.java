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

	public Table selectTable(int tableID, Order order) throws NullPointerException {
		Table table = TableContainer.getInstance().findTableByID(tableID);
		
		if (table == null) {
			throw new NullPointerException("Table out of range");
		}
		
		return table;
	}
	
	public ArrayList<Table> getTables() {
		return tableContainer.getTables();
	}

	public void setActiveTable(int tableID) {
		tableContainer.setActiveTable(tableID);
	}
	
}
