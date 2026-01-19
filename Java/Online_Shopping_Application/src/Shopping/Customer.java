package Shopping;

import java.util.Scanner;

public class Customer {
	private String customerId;
	private String customerName;
	public String email;
	String address;
	Scanner scan = new Scanner(System.in);
	public Customer() {
		customerId="";
		customerName="";
		email="";
		address="";
	}
	
	public Customer(String customerId, String customerName, String email, String address) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.address = address;
	}
	void Setter(){
		System.out.print("Enter Customer ID: ");
		customerId = scan.next();
		System.out.print("Enter Customer Name: ");
		customerName = scan.next();
		System.out.print("Enter Customer E-mail: ");
		email = scan.next();
	}
	
	void Getter()  {
		System.out.println(" Customer ID: "+customerId );
		System.out.println("Customer Name: "+customerName);
		System.out.println("Customer E-mail: "+email);
	}
}
