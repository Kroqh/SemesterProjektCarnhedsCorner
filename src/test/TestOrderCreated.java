package test;

import controller.OrderController;
import controller.ProductController;
import model.Product;
import model.TableContainer;

import org.junit.*;
public class TestOrderCreated {

	
	OrderController orderController;
	ProductController productController;
	
	@Before
	public void setUp() {
		orderController = new OrderController();
		productController = new ProductController();
	}
	
	@Test
	public void OrderWasCreated() {
		
		
		
		try {
			orderController.createOrder(2);
			Product p = productController.findProductByID(13);
			Product p2 = productController.findProductByID(14);
			orderController.addProductToOrder(p, 5);
			orderController.addProductToOrder(p2, 2);
			orderController.saveOrder(orderController.getCurrentOrder().getTotalPrice());
		} catch (Exception e) {
			Assert.fail("Exception " + e);
		}
		
		
		
	}
	
	
}
