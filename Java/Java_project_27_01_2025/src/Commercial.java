import java.util.Scanner;

public class Commercial implements Rent_Aggrement {
	int duration;
	int cost = 4000;
	public Commercial() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the duration of the aggrement: ");
		duration = scan.nextInt();
	}
	@Override
	public void duration_of_aggrement() {
		// TODO Auto-generated method stub
		System.out.println("The duration of aggrement is: "+duration);
		
	}

	@Override
	public void cost_of_agreement() {
		// TODO Auto-generated method stub
		System.out.println("The cost of the aggrement: "+duration*cost);
	}

}
