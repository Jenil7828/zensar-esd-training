import java.util.*;

public class Marksheet_Generation {
	String []subjects;
	int [][]marks;
	int []total;
	int n;
	Scanner scan = new Scanner(System.in);
	void input_subject() {
		System.out.print("Enter the number of subjects you want");
		n = scan.nextInt();
		subjects = new String[n];
		for(int i = 0; i < subjects.length; i++) {
			System.out.print("Enter "+(i+1)+" subject:" );
			subjects[i] = scan.next();
		}
	}
	void input_marks() {
		marks = new int[4][n];
		for(int i = 0; i < 4; i ++) {
			System.out.println("Enter the marks of "+(i+1)+" year:");
			for( int j = 0; j<n;j++) {
				System.out.print("Enter the marks of "+subjects[j]+ " for year "+(i+1)+": ");
				marks[i][j] = scan.nextInt();
			}
		}
	}
	
	void calculate_marksheet() {
		total = new int[n];
		for(int j = 0; j<n;j++) {
			for(int i = 0; i < 4; i ++ ) {
				total[j] = total[j]+marks[i][j];
			}
		}
	}
	
	boolean is_internship_ready(int total[]) {
		for(int i = 0; i< n;i++){
			if(total[i]< 200) {
				return false;
			}
		}
		return true;
	}
	
	void internship() {
		calculate_marksheet();
		if(is_internship_ready(total)) {
			int max_at = 0;
			int max= total[max_at];
			for(int i = 1; i < total.length; i++) {
				if(max < total[i]) {
					max = total[i];
					max_at = i;
				}	
			}
			System.out.println("Student can do internship in: "+subjects[max_at]+" with marks: "+max);
		}
		else {
			System.out.println("Student has failed in one or more subjets and cannot pursue internship");
		}
	}
	
	void display_sub() {
		System.out.println("\n\n");
		for (int i = 0; i < n; i++) {
			System.out.print(subjects[i]+": ");
			for(int j = 0; j < 4; j++) {
				System.out.print(marks[j][i]+" ");
			}
			System.out.println();
		}
	}
	void display_marks() {
		System.out.println("\n\n");
		for(int i = 0; i< n;i++){
			System.out.println("Total marks in "+ "subject: "+subjects[i]+" is: "+total[i]);
			}
	}
	public static void main(String[] args) {
		Marksheet_Generation student = new Marksheet_Generation();
		student.input_subject();
		student.input_marks();
		student.display_sub();
		student.internship();
		student.display_marks();
		
		
	}
}
