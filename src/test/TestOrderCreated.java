package test;


import static org.junit.Assert.*;
import controller.OrderController;
import model.Employee;
import model.TableContainer;
import model.Table;

import org.junit.*;
public class TestOrderCreated {

	
	OrderController orderController;
	Employee tester;
	int tablesForTest = 8;
	
	@Before
	public void setUp() {
		orderController = new OrderController();
		tester = new Employee("Tester");
		for (int i = 0; i < tablesForTest; i++) {
			  TableContainer.getInstance().addTable();
			}
	}
	
	@Test
	public void OrderWasCreated() {
		
		orderController.createOrder(tester);
		
		try {
			orderController.selectTable(0);
			orderController.addProductToOrder(1, 5);
			orderController.addProductToOrder(2, 2);
			orderController.saveOrder(orderController.getCurrentOrder().getTotalPrice());
		} catch (Exception e) {
			Assert.fail("Exception " + e);
		}
		
		
		
	}
	
	
}
