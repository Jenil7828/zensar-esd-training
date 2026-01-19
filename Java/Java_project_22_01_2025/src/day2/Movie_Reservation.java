package day2;

import java.util.Scanner;

public class Movie_Reservation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]cinema = new int[5][5];
		Scanner scan = new Scanner(System.in);
		
		
		do{
			System.out.print("Enter the number of seats you wanna book: ");
			int seat_count = scan.nextInt();
			int avail= 0;
			for(int row=0; row<5;row++) {
				for(int column = 0; column < 5; column++) {
					if(cinema[row][column] == 0) {
						avail+=1;
					}
				}
				System.out.println();
			}
			if(avail>seat_count) {
				for(int ticket = 1; ticket <= seat_count; ticket++) {
					String s = "";
					outermost:
						for(int row=0; row<5;row++) {
							for(int column = 0; column < 5; column++) {
								if(cinema[row][column] == 0) {
									cinema[row][column] = 1;
									s = s+"\nSeat "+ticket+" at: row"+row+"column"+column;
									break outermost;
								}
							}
						}
					System.out.println(s);
				}
			
				for(int row=0; row<5;row++) {
					for(int column = 0; column < 5; column++) {
						System.out.print(cinema[row][column]);
					}
					System.out.println();
				}
			}
			else {
				System.out.println("Cannot Book so many tickets seats are full");
			}
			System.out.println("Do you want to perform another operation? (yes/no):");
			String response = scan.next();
			if (response.equalsIgnoreCase("no")) {
				break;
			}
			
		}while(true);
		scan.close();
	}
}
