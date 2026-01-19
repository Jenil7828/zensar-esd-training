package company;

import java.util.Scanner;

public class Employee {
	String Name;
	int id;
	float salary;
	static int count=0;
	public Employee() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Employee Name: ");
		Name = scan.next();
		System.out.print("Enter ID: ");
		id = scan.nextInt();
		System.out.print("Enter salary: ");
		salary = scan.nextFloat();
		count++;
	}
	
	void displayinfo() {
		System.out.println("\n\nEmployee Name: "+Name);
		System.out.println("Employee ID: "+id);
		System.out.println("Employee Salary: "+salary);
	}

}
