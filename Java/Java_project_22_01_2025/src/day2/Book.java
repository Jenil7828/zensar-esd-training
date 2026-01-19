package day2;

import java.util.Scanner;

public class Book {
	String title;
	String author;
	int prize;
	Scanner scan = new Scanner(System.in);
	
	public Book() {
		System.out.print("Enter the Title of book: ");
		title = scan.next();
		System.out.print("Enter the Author of book: ");
		author = scan.next();
		System.out.print("Enter the Prize of book: ");
		prize = scan.nextInt();
	}
	public Book(String t, String a, int p) {
		title = t;
		author = a;
		prize = p;
	}
	void displayDetails() {
		System.out.println(title+author+prize);
	}
}
