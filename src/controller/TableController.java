package controller;

import model.Order;
import model.Table;
import model.TableContainer;

public class TableController {

	public Table selectTable(int tableID, Order order) throws NullPointerException {
		Table table = TableContainer.getInstance().findTableByID(tableID);
		
		if (table == null) {
			throw new NullPointerException("Table out of range");
		}
		
		return table;
	}

}
