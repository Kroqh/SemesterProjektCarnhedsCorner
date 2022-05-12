package model;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {

	private int orderID;
	private float totalPrice;
	private LocalDateTime date;
	private boolean paymentStatus;
	private ArrayList<OrderLine> orderLines;
	
	public Order() {
	date = LocalDateTime.now();
	orderLines = new ArrayList<OrderLine>();
	
	//TODO: Add id
	}
}
