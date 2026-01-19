package day1;

import java.util.Scanner;

public class odd_even_do_while {
	public static void main(String[] args) {
		do {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter Number");
			int a = scan.nextInt();
			if (a%2==0)
				System.out.println(a+"is even");	
			System.out.println("Do you want to perform another operation? (yes/no):");
			String response = scan.next();
			if (response.equalsIgnoreCase("no")) {
				scan.close();
				break;
			}
		scan.close();
        }while(true);
		
	}

}
