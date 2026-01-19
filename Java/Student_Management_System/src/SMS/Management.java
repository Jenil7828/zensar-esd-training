package SMS;

public class Management {
	public static void main(String[] args){
		Student stud = new Student();
		stud.displayinfo();
		
		Staff staff = new Staff();
		staff.displayinfo();
		
		Teacher teach = new Teacher();
		teach.displayinfo();
		
		System.out.println("There are :"+Person.count+" in the system");
		
			
	}
}
