package day2;

import java.util.Scanner;

public class Vehicle {
	String Company;
	int Model_no;
	int Seat_Capacity;
	Scanner scan = new Scanner(System.in);
	public Vehicle() {
		System.out.println("Enter Vehicle Company");
		Company = scan.next();
		System.out.println("Enter Vehicle Model");
		Model_no = scan.nextInt();
		System.out.println("Enter Vehicle Seat Capacity");
		Seat_Capacity = scan.nextInt();
	}
	public Vehicle(String Company, int Model_no, int Seat_Capacity) {
		this.Company = Company;
		this.Model_no = Model_no;
		this.Seat_Capacity = Seat_Capacity;
	}
	void Display() {
		System.out.println("Company: "+ Company+"\nModel: "+Model_no+"\nSeat Capacity: "+Seat_Capacity);
	}
}
