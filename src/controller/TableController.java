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
	public void releaseTable(int tableID) {
		tableContainer.getTables().get(tableID).releaseTable();
	}
	
	public ArrayList<Table> getTables() {
		return tableContainer.getTables();
	}
	
}
