package model;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {

	private int orderID;
	private float totalPrice;
	private LocalDateTime date;
	private boolean paymentStatus;
	private ArrayList<OrderLine> orderLines;
	private Table table;
	private Employee employee;
	
	public Order(Employee employee) {
	this.employee = employee;
	date = LocalDateTime.now();
	orderLines = new ArrayList<OrderLine>();
	
	//TODO: Add id via db?
	}
	
	public void setTable(Table table) {
		this.table = table;
	}
}
