package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.OrderLine;

public class OrderLineDB implements IOrderLineDB {

	public void saveOrderLine(OrderLine orderLine, int orderID) throws DataAccessException {
		
		Connection con = DBConnection.getInstance().getConnection();
		
		String baseInsert = "insert into CHC_OrderLines (fk_OrderID, fk_ProductID, quantity) values(?, ?, ?);";
		
		try {
			PreparedStatement stmt = con.prepareStatement(baseInsert);
			stmt.setInt(1, orderID);
			stmt.setInt(2, orderLine.getProductID());
			stmt.setInt(3, orderLine.getQuantity());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
