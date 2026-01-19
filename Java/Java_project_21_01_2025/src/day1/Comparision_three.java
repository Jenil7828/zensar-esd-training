package day1;

public class Comparision_three {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 20;
		int c = 30;
		if((a > b) && (a > c))  {
			System.out.println("Number 1 is greater");
		}
		else if((a < b) && (b > c)) {
			System.out.println("Number 2 is greater");
		}
		else{
			System.out.println("Number 3 is greater");
		}
	}

}
