package Shopping;
import java.util.Scanner;

public class Product {
	private String productId;
	private String productName;
	protected double price;
	int stockQuantity;
	Scanner scan = new Scanner(System.in);
	public Product() {
		productId = "";
		productName = "";
		price = 0;
		stockQuantity = 0;
	}
	public Product(String productId, String productName, double price, int stockQuantity) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	
	void  Setter() {
		System.out.print("Enter Product ID: ");
		productId = scan.next();
		System.out.print("Enter Product Name: ");
		productName = scan.next();
		System.out.print("Enter Product Price: ");
		price = scan.nextDouble();
	}
	
	void Getter() {
		System.out.println(" Product ID: "+productId );
		System.out.println("Product Name: "+productName);
		System.out.println("Product Price: "+price);
	}
	protected void stockQuant() {
		System.out.println("Stock Quantity: "+stockQuantity);
	}
	
	void updateStock() {
		System.out.print("Enter Product Stock Quantity: ");
		stockQuantity = scan.nextInt();
	}
}
