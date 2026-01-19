package day7;

public class No_Divide_By_Zero {
	public static void main(String[] args) {
		int a, b;
		try {
			a = 5;
			b = 0;
			System.out.println("The Division of "+a+" and "+b+": "+a/b);
			
		}
		catch(Exception e){
			System.out.println("Exception "+e.getMessage()+" Occured");
		}
		finally {
		System.out.println("HEllo");
		}
	}
}
