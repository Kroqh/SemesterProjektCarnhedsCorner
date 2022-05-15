package controller;
import database.DataAccessException;
import database.OrderDB;
import model.Employee;
import model.Order;
import model.Product;

public class OrderController {
	private Order currentOrder;
	private TableController tableController;
	private ProductController productController;
	private OrderDB orderDB;
	
	public OrderController() {
		tableController = new TableController();
		productController = new ProductController();
		orderDB = new OrderDB();
	}
	
	public void CreateOrder(Employee employee) {
		currentOrder = new Order(employee);
	}
	public void selectTable(int tableID) {
		currentOrder.setTable(tableController.SelectTable(tableID,currentOrder));
	}
	
	public void addProductToOrder(int productID, int quantity) throws Exception {
		Product product = productController.findProductByID(productID);
		currentOrder.addOrderLine(product, quantity);
	}
	public void saveOrder(float payAmount) throws DataAccessException, InsufficientPaymentException {
		if (payAmount >= currentOrder.getTotalPrice()) {
			orderDB.saveOrder(currentOrder);
		}
		else {
			throw new InsufficientPaymentException("Insufficient payment");
		}
	}
}	
