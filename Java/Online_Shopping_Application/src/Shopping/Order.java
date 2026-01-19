package Shopping;

import java.util.Scanner;

public class Order {
	private Product prod = new Product();
	private Customer cust = new Customer();
	protected String orderStatus;
	protected String orderDate;
	Scanner scan = new Scanner(System.in);
	
	public Order(Product prod, Customer customer, String orderStatus, String orderDate) {
        this.prod = prod;
        this.cust = customer;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }
	void updatestatus() {
		System.out.print("Enter Order Status: ");
		orderStatus = scan.next();
	}
	
	void display() {
		System.out.println("Order Details:");
        System.out.println("Product: ");
        prod.Getter();
        System.out.println("Customer: " );
        cust.Getter();
        System.out.println("Status: " + orderStatus);
        System.out.println("Order Date: " + orderDate);
	}
}
