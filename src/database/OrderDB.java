package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Order;
import model.OrderLine;

public class OrderDB {
	
	private OrderLineDB orderLineDB;
	
	public void saveOrder(Order order) throws DataAccessException {
		int insertedKey = 0;
		Connection con = DBConnection.getInstance().getConnection();
		
		String baseInsert = "insert into CHC_Orders (date, totalPrice, paymentStatus) values";
		baseInsert = "( ?, ?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(baseInsert, Statement.RETURN_GENERATED_KEYS);
			// can we do a setDateTime ???
			stmt.setString(1, order.getDate().toString());
			stmt.setFloat(2, order.getTotalPrice());
			stmt.setBoolean(3, order.isPaymentStatus());
			insertedKey = DBConnection.getInstance().executeInsertWithIdentity(stmt);
			stmt.close();
			
		
			ArrayList orderLines = order.getOrderLines();
			
			
			
			for (int i=0; i<orderLines.size(); i++) {
				OrderLine orderLine = (OrderLine) orderLines.get(i);
				orderLineDB.saveOrderLine(orderLine, insertedKey);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
