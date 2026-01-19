package day1;
import java.util.*;
public class Operations_from_Input {

	int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the first number:");
			int a = scan.nextInt();
			System.out.println("Enter the second number:");
			int b = scan.nextInt();
			System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division");
			System.out.println("Enter your choice:");
			int n = scan.nextInt();
			switch(n) {
				case 1:
					add c = new add();
					System.out.println("Addition of 2 number: "+ c.calc(a, b));
					break;
				case 2:
					sub c1 = new sub();
					System.out.println("Subtraction of 2 number: "+ (c1.calc(a, b)));
					break;
				case 3:
					mul c3 = new mul();
					System.out.println("Multiplication of 2 number: "+ (c3.calc(a, b)));
					break;
				case 4:
					div c4 = new div();
					System.out.println("Division of 2 number: "+ (c4.calc(a, b)));
					break;
				default:
					System.out.println("Invalid entry" );
					break;
			}
			System.out.println("Do you want to perform another operation? (yes/no):");
			String response = scan.next();
			if (response.equalsIgnoreCase("no")) {
				break;
			}
			scan.close();
		}while(true);
	}
}






		


