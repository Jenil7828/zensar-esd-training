package Shopping;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product product = new Product("P001", "Laptop", 999.99, 100);
        Customer customer = new Customer("C001", "Alice", "alice@example.com", "123 Main St");
        Order order = new Order(product, customer, "Placed", "2025-01-24");
        Payment payment = new Payment("PAY001", 999.99, "Paid");
        product.Getter();
        order.updatestatus();
        order.display();
        payment.processPayment();
        System.out.println("Payment Status: " + payment.getPaymentStatus());

        // Access protected and default attributes
        product.stockQuant();
        product.updateStock();
	}

}
