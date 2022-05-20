package database;

import model.OrderLine;

public interface IOrderLineDB {
	public void saveOrderLine(OrderLine orderLine, int orderID) throws DataAccessException;

}
