package day3;

public class Book {
	static int totalbooks;
	String title;
	String author;
	int bookID;
	static {
		totalbooks = 0;
		System.out.println("Static Block executed: totalBooks in block are: "+totalbooks);
	}
	{
		bookID =totalbooks+1;
		totalbooks++;
		System.out.println("Instance Block executed : bookId assigned"+ bookID);
	}
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		System.out.println("Book Title: "+title);
		System.out.println("Author: "+author);
	}
	public void displayBookDetails() {
		System.out.println("Book ID :"+bookID);
		System.out.println("Book Title: "+title);
		System.out.println("Author: "+author);

	}
	public static void displayTotalBooks() {
		System.out.println("Total books in Library: "+totalbooks);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book1 = new Book("To Kill a Mockingbird", "Harper");
		book1.displayBookDetails();
		
		Book book2 = new Book("1984", "George Orwell");
		book2.displayBookDetails();
		
		Book book3 = new Book("The Great Gatsby", "F. Scott Fit");
		book3.displayBookDetails();
		
		Book.displayTotalBooks();

	}

}
