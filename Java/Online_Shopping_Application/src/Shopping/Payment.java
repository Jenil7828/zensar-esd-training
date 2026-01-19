package Shopping;

public class Payment {
	private String paymentId;
	protected double paymentAmount;
	String paymentStatus;
	public Payment(String paymentId, double paymentAmount, String paymentStatus) {
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.paymentStatus = paymentStatus;
    }
	public void processPayment() {
        System.out.println("Payment of " + paymentAmount + " processed.");
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
}
