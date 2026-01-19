package day2;
import java.util.Scanner;
public class maximum_of_all {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []max = new int[15];
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 15; i++) {
			System.out.print("Enter the number "+(i+1));
			int mrk = scan.nextInt();
			max[i] = mrk;
		}
		scan.close();
		int temp;
		for(int i = 0; i < 15; i++) {
			for(int j = i+1; j < 15; j++) {
				if(max[i] > max[j]) {
					temp = max[i];
					max[i] = max[j];
					max[j]= temp;
				}
			}
		}
		System.out.println("The maximum value is "+max[14]);
	}
}
