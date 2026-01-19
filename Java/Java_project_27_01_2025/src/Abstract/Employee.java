package Abstract;

import java.util.Scanner;

public abstract class Employee {
	Scanner scan =  new Scanner(System.in);
	String Name;
	int id;
	double salary;
	
	public Employee(String Name, int id) {
		this.Name = Name;
		this.id = id;
		System.out.println("Name: "+Name);
		System.out.println("ID: "+id);
	}
	
	public abstract double calculate();
}

class Salaried extends Employee {
	double annualSalary;
	public Salaried(String Name, int id) {
		super(Name, id);
		System.out.print("Enter Annual Salary: ");
		annualSalary = scan.nextDouble();
	}
	
	public double calculate() {
		return annualSalary/12;
	}
}

class Hourly extends Employee {
	int Hours;
	double Hourly_Rate;
	public Hourly(String Name, int id) {
		super(Name, id);
		System.out.print("Enter Hourly Salary Rate: ");
		Hourly_Rate = scan.nextDouble();
		System.out.print("Enter Hours Worked: ");
		Hours = scan.nextInt();
	}
	
	public double calculate() {
		return Hours*Hourly_Rate;
	}
}
