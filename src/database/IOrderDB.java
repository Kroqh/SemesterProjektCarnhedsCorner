package database;

import model.Order;

public interface IOrderDB {
	public void saveOrder(Order order) throws DataAccessException;
	
}
