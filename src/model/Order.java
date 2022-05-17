package model;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Order {

	private int orderID;
	private LocalDateTime date;
	private boolean paymentStatus;
	private ArrayList<OrderLine> orderLines;
	private Table table;
	
	public Order(Table table) {
		date = LocalDateTime.now();
		date = date.truncatedTo(ChronoUnit.MINUTES);
		this.table = table;
	
		orderLines = new ArrayList<OrderLine>();
	}
	
	public void addOrderLine(Product product, int quantity) {
		boolean found = false;
		int i = 0;
		while(orderLines.size() != 0 && found == false && i < orderLines.size() ) {
			
			if(orderLines.get(i).getProduct().getID() == product.getID()) {
				found = true;
				orderLines.get(i).addQuantity(quantity);
						
			}
			i++;
		}
		if (!found) {
			OrderLine orderLine = new OrderLine(product,quantity);
			orderLines.add(orderLine);
		}
		
	}
	
	public void setTable(Table table) {
		this.table = table;
	}

	public float getTotalPrice() {
		
		float totalPrice = 0;
		for(OrderLine orderLine : orderLines) {
			totalPrice += orderLine.getProduct().getPrice() * orderLine.getQuantity();
		}
		
		return totalPrice;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setPaymentStatus(boolean isPayed) {
		paymentStatus = isPayed;
	}
	public boolean isPaymentStatus() {
		return paymentStatus;
	}
	
}
