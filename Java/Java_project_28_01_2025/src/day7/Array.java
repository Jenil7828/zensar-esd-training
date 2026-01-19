package day7;

import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = new int[5];
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 5; i++) {
			System.out.print("Enter "+(i+1)+ " element");
			arr[i] = scan.nextInt();
		}
		try {
			for(int i = 0; i < 6; i++) {
				System.out.println( arr[i]);
			}
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage()+" occured");
		}finally {
			System.out.println("Array Traversed....");
			scan.close();
		}
	}

}
