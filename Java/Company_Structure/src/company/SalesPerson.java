package company;
import java.util.Scanner;
class SalesPerson extends Employee {
	int targetSales;
	static int sale_count = 0;
	public SalesPerson() {
		
		super();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Sales Target: ");
		targetSales = scan.nextInt();
		sale_count++;
	}
	void achieveTarget() {
		System.out.println(Name+ " has sales Target of "+targetSales+"\n");
	}
	
	void displayinfo() {
		super.displayinfo();
		System.out.println("Sales Target: "+targetSales);
	}
}
