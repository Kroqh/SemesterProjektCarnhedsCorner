package test;

import controller.OrderController;
import controller.ProductController;
import model.TableContainer;
import model.Product;

import org.junit.*;
public class TestDupeProduct {

	
	OrderController orderController;
	ProductController productController;
	
	@Before
	public void setUp() {
		orderController = new OrderController();
		productController = new ProductController();
	}
	
	//Adds 2 of the same product, checks if it succesfully adds to quantity instead of creating a new orderline
	@Test
	public void ProductDupeSuccesful() {
		
		try {
			orderController.createOrder(1);
			Product p = productController.findProductByID(13);
			orderController.addProductToOrder(p, 5);
			orderController.addProductToOrder(p, 2);
			Assert.assertEquals(7, orderController.getCurrentOrder().getOrderLines().get(0).getQuantity());
		} catch (Exception e) {
			Assert.fail("Exception " + e);
		}
		
		
		
	}
	
	
}
