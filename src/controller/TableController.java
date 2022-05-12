package controller;

import model.Order;
import model.Table;
import model.TableContainer;

public class TableController {

	public Table SelectTable(int tableID, Order order) {
		Table table = TableContainer.getInstance().findTableByID(tableID);
		table.setActive(order);
		return table;
	}

}
