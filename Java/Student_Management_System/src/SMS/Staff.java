package SMS;

import java.util.Scanner;

class Staff extends Person {
	String jobtitle;
	String department;
	
	public Staff(String Name, int id, String jobtitle, String department) {
		super(Name, id);
		this.jobtitle = jobtitle;
		this.department = department;
	}
	public Staff() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Staff Name: ");
		Name = scan.next();
		System.out.print("Enter id: ");
		id = scan.nextInt();
		System.out.print("Enter Job Title: ");
		jobtitle = scan.next();
		System.out.print("Enter Department: ");
		department = scan.next();
		
	}

	void displayinfo() {
		System.out.println("Staff Information");
		super.displayinfo();
		System.out.println("Job Title: "+jobtitle);
		System.out.println("Department: "+department);
	}
}
