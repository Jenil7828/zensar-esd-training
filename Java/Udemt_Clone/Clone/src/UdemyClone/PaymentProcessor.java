package UdemyClone;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentProcessor implements Payment {
    private int courseId;
    private String paymentMode;
    private float amount;
    private String remark;
    private String discount;
    public Database db = new Database();
    // Constructor
    public PaymentProcessor(int courseId, int userId, String paymentMode, float amount, String remark, String discount) {
        this.courseId = courseId;
        this.paymentMode = paymentMode;
        this.amount = amount;
        this.remark = remark;
        this.discount = discount;
    }
	
	public String payment_method(User currentUser, String mode, ResultSet rs, Payment payment) {
	    	
	        // After payment, enroll user into the course
	        String enrollQuery;
			try {
				int payID = processPayment(currentUser.getUserId(), courseId, mode);
				enrollQuery = "INSERT INTO USER_COURSE (USER_ID, TITLE, COMPLETE_NESS, COURSE_ID, PAY_ID, BUY_DATE) "
				        + "VALUES (" + currentUser.getUserId() + ", '" + rs.getString("TITLE") + "', 0, " + courseId + "," + payID + " , CURDATE())";
				db.insert(enrollQuery);
				enrollQuery = "UPDATE USERS SET COURSE_COUNT ="+currentUser.getCourseCount()+"+1 WHERE USER_ID = "+currentUser.getUserId()+";";
				db.update(enrollQuery);
		        return "Successfull";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return "Failed";
	}
	 // Method to apply discounts
    private float applyDiscount() {
        Discount discountHandler = new Discount(); // Create an instance of Discount to handle discount logic
        // Get the coupon discount from the Discount class
        double couponDiscount = discountHandler.getCouponDiscount(discount);
        // Get the day-based discount (e.g., weekend, festival)
        double dayDiscount = discountHandler.getDayDiscount();
        // Calculate total discount (use the higher of the two)
        double totalDiscount = Math.max(couponDiscount, dayDiscount);
        // Apply the discount to the amount
        float finalAmount = (float) (amount * (1 - totalDiscount));
        return finalAmount; // Return the final amount after discount
    }

    // Payment process
	@Override
    public int processPayment(int userId, int courseId, String paymentMethod) {
		float finalAmount = applyDiscount();
		String query = "INSERT INTO PAYMENTS (COURSE_ID, USER_ID, MODE, AMOUNT, REMARK, DISCOUNT, BUY_DATE, BUY_TIME) "
                     + "VALUES (" + courseId + ", " + userId + ", '" + paymentMode + "', " + finalAmount + ", '" + remark + "', '" + discount + "', CURDATE(), CURTIME())";
        Database db = new Database(); // Update with actual credentials
        db.insert(query);
        System.out.println("Payment processed successfully.");
     // Retrieve the last inserted PAY_ID
        String getIdQuery = "SELECT LAST_INSERT_ID()";
        ResultSet rs = db.Select(getIdQuery);
        int payId = -1;

        try {
            if (rs.next()) {
                payId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if (payId > 0) {
            System.out.println("\n\nPayment processed successfully. Payment ID: " + payId);
            System.out.println("Final Amount: "+finalAmount);
            System.out.println("\n\n");
        } else {
            System.out.println("Payment failed.");
        }

        return payId;
        
    }
	
	
}
