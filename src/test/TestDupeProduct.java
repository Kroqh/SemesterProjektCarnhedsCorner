package test;

import controller.OrderController;
import model.TableContainer;

import org.junit.*;
public class TestDupeProduct {

	
	OrderController orderController;
	int tablesForTest = 8;
	
	@Before
	public void setUp() {
		orderController = new OrderController();
		for (int i = 0; i < tablesForTest; i++) {
			  TableContainer.getInstance().addTable();
			}
	}
	
	//Adds 2 of the same product, checks if it succesfully adds to quantity instead of creating a new orderline
	@Test
	public void ProductDupeSuccesful() {
		
		
		
		try {
			orderController.createOrder(0);
			orderController.addProductToOrder(1, 5);
			orderController.addProductToOrder(1, 2);
			Assert.assertEquals(7, orderController.getCurrentOrder().getOrderLines().get(0).getQuantity());
		} catch (Exception e) {
			Assert.fail("Exception " + e);
		}
		
		
		
	}
	
	
}
