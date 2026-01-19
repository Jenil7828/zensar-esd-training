package company;
import java.util.Scanner;
class Developer extends Employee {
	String programminglanguage;
	static int dev_count = 0;
	public Developer() {
		
		super();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Programming Language Name: ");
		programminglanguage = scan.next();
		dev_count++;
	}
	void code() {
		System.out.println(Name+ " code in: "+programminglanguage+"\n");
	}
	
	void displayinfo() {
		super.displayinfo();
		System.out.println("Programming Language Used: "+programminglanguage);
	}
}
