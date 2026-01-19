package UdemyClone;

public interface Payment {
	int processPayment(int userId, int courseId, String paymentMethod);
}
