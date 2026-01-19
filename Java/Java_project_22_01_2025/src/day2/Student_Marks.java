package day2;

import java.util.Scanner;
class Student_Marks {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []marks = new int[10];
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			System.out.println("Enter the marks of subject "+(i+1));
			int mrk = scan.nextInt();
			marks[i] = mrk;
			
		}
		scan.close();
		for (int i = 0; i < 10; i++) {
			if (marks[i] >60) {
				System.out.println(marks[i]);
			}
		}
	}
}