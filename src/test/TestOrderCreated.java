package test;

import controller.OrderController;
import model.TableContainer;

import org.junit.*;
public class TestOrderCreated {

	
	OrderController orderController;
	int tablesForTest = 8;
	
	@Before
	public void setUp() {
		orderController = new OrderController();
		for (int i = 0; i < tablesForTest; i++) {
			  TableContainer.getInstance().addTable();
			}
	}
	
	@Test
	public void OrderWasCreated() {
		
		
		
		try {
			orderController.createOrder(0);
			orderController.addProductToOrder(1, 5);
			orderController.addProductToOrder(2, 2);
			orderController.saveOrder(orderController.getCurrentOrder().getTotalPrice());
		} catch (Exception e) {
			Assert.fail("Exception " + e);
		}
		
		
		
	}
	
	
}
