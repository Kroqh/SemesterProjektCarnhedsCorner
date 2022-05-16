package model;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {

	private int orderID;
	private LocalDateTime date;
	private boolean paymentStatus;
	private ArrayList<OrderLine> orderLines;
	private Table table;
	private Employee employee;
	
	public Order(Employee employee) {
	this.employee = employee;
	date = LocalDateTime.now();
	orderLines = new ArrayList<OrderLine>();
	}
	public void addOrderLine(Product product, int quantity) {
		boolean found = false;
		int i = 0;
		while(found = false && i < orderLines.size()) {
			i++;
			if(orderLines.get(i).getProduct() == product) {
				found = true;
				orderLines.get(i).addQuantity(quantity);
						
			}
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
			totalPrice += orderLine.getProduct().GetPrice() * orderLine.getQuantity();
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
