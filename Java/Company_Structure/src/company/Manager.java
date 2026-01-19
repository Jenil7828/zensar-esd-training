package company;
import java.util.Scanner;
class Manager extends Employee {
	String department;
	static int man_count = 0;
	public Manager() {
		
		super();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Department Name: ");
		department = scan.next();
		man_count++;
	}
	void manageTeam() {
		System.out.println(Name+ " manages "+department+"\n");
	}
	
	void displayinfo() {
		super.displayinfo();
		System.out.println("Department: "+department);
	}
}
