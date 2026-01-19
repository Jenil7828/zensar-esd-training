import java.util.Scanner;

public class Main_College {
	public static void main(String[] args) {
		System.out.print("1. Engineering\n2. Diploma\n3. MBA\nEnter your choice: ");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		switch(choice) {
			case 1:
				Engineering eng = new Engineering();
				eng.duration_of_course();
				eng.placement();
				eng.cultural_activities();
				break;
			case 2:
				Diploma dip = new Diploma();
				dip.duration_of_course();
				dip.placement();
				dip.cultural_activities();
				break;
			case 3:
				MBA mba = new MBA();
				mba.duration_of_course();
				mba.placement();
				mba.cultural_activities();
				break;
			default:
				System.out.println("Invalid choice..");
				break;
		}
	}
}
