package day1;

import java.util.Scanner;

public class For_loop_Table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the value you need table for:");
		int v = sc.nextInt();
		sc.close();
		for(int i =1; i <11;i++) {
			System.out.println(v+"x"+i+"="+(v*i));
		}
	}

}
