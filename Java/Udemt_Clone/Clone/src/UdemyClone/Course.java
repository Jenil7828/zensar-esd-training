package UdemyClone;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Course {
    private int courseId;
    private String title;
    private String domain;
    private String description;
    private float price;
    private int rating;
    private int reviewCount;
    private int moduleCount;
    public Database db = new Database();
 
    public ResultSet get() {
    	
        if(db.rs != null) {
        	return db.rs;
        }
        return null;
    }
    
    public void displayCourseDetails() {
        System.out.println("CourseID\tTitle\t\t\t\tDomain\t\t\t\tDescription\t\t\t\t\tPrice\tRating\tNumver of reviews Number of Module");
        try {
        	String query = "SELECT * FROM COURSE";
            // Update with actual credentials
        	Database db = new Database();
        	db.rs = db.Select(query);
        	while(db.rs.next()){
	            if (db.rs != null ) {
	            	courseId = db.rs.getInt("COURSE_ID");
	            	title = db.rs.getString("TITLE");
	            	domain = db.rs.getString("DOMAINs");
	            	description = db.rs.getString("DESCRIPTION");
	            	price = db.rs.getInt("PRICE");
	            	reviewCount = db.rs.getInt("REVIEW_COUNT");
	            	moduleCount = db.rs.getInt("MODULE_COUNT");
	            	rating = db.rs.getInt("RATING");
	            	
	            	System.out.println(courseId+"\t\t"+title+"\t\t"+ domain+"\t\t"+description+"\t\t"+price+"\t"+ rating + "\t" + reviewCount + "\t\t" + moduleCount);
	            }
        	}
        }
        catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
    
    public void buy_course(User currentUser, int courseId, String paymentMode, String discount) {
        // Retrieve the course price from the database
        String courseQuery = "SELECT * FROM COURSE WHERE COURSE_ID = " + courseId;
        float originalPrice = 0.0f;
        try {
            ResultSet rs = db.Select(courseQuery);
            if (rs.next()) {
                originalPrice = rs.getFloat("PRICE");

                // Apply discount (if any)
                Discount discountHandler = new Discount();
                float finalPrice = originalPrice;

                // Apply coupon discount if provided
                if (!discount.isEmpty()) {
                    double couponDiscount = discountHandler.getCouponDiscount(discount);
                    if (couponDiscount > 0) {
                        finalPrice *= (1 - couponDiscount); // Apply coupon discount
                        System.out.println("Applied coupon discount: " + (couponDiscount * 100) + "%");
                    } 
                    else {
                        System.out.println("Invalid or expired coupon code.");
                    }
                }
                // Apply day-based discount (e.g., weekend, festival)
                double dayDiscount = discountHandler.getDayDiscount();
                if (dayDiscount > 0) {
                    finalPrice *= (1 - dayDiscount); // Apply day-based discount
                    System.out.println("Applied day-based discount: " + (dayDiscount * 100) + "%");
                    PaymentProcessor payment = new PaymentProcessor(courseId, currentUser.getUserId(), paymentMode, finalPrice, "Pending", discount);
                    if(payment.payment_method(currentUser, paymentMode, rs, payment).equalsIgnoreCase("Successfull")) {
            	        System.out.println("You have successfully purchased the course!");
                    }
                }
                else {
        	        System.out.println("Purchased Failed!");
                }
            } 
            else {
                System.out.println("Course not found.");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
