package day2;

public class Book_Use {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book []books = new Book[6];
		for(int i = 0 ; i < 3; i++) {
			books[i] = new Book();
			
		}
		for(int i = 0 ; i < 3; i++) {
			books[i].displayDetails();
		}
	}

}
