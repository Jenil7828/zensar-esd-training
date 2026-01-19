package day1;

import java.util.Scanner;
public class Comparision_from_input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the first number:");
		int a = scan.nextInt();
		System.out.print("Enter the second number:");
		int b = scan.nextInt();
		if(a > b) {
			System.out.println("Number 1 is greater than number 2");
		}
		else{
			System.out.println("Number 2 is greater than number 1");
		}
		
		scan.close();
	}

}
