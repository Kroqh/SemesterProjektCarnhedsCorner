package controller;
import model.Employee;
import model.Order;

public class OrderController {
	private Order currentOrder;
	private TableController tableController;
	private ProductController productController;
	
	public OrderController() {
		tableController = new TableController();
	}
	
	public void CreateOrder(Employee employee) {
		currentOrder = new Order(employee);
	}
	public void selectTable(int tableID) {
		currentOrder.setTable(tableController.SelectTable(tableID,currentOrder));
	}
}	
