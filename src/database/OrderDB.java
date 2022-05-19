package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Order;
import model.OrderLine;

public class OrderDB {
	
	private OrderLineDB orderLineDB = new OrderLineDB();
	
	public void saveOrder(Order order) throws DataAccessException {
		int insertedKey = 0;
		Connection con = DBConnection.getInstance().getConnection();
		
		String baseInsert = "insert into CHC_Orders (date, paymentStatus) ";
		baseInsert += "values (?,?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(baseInsert, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, order.getDate().toString());
			stmt.setBoolean(2, order.isPaymentStatus());
			insertedKey = DBConnection.getInstance().executeInsertWithIdentity(stmt);
			stmt.close();
			
			ArrayList<OrderLine> orderLines = order.getOrderLines();
			for (int i=0; i<orderLines.size(); i++) {
				OrderLine orderLine = (OrderLine) orderLines.get(i);
				orderLineDB.saveOrderLine(orderLine, insertedKey);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
