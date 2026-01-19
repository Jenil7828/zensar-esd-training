package UdemyClone;

import java.sql.SQLException;
import java.util.Scanner;

public class Review {
    
    public static void review() {
    	try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the course ID you want to review:");
			int courseId = sc.nextInt();
			sc.nextLine(); // Consume newline character
			System.out.println("Enter your review:");
			String review = sc.nextLine();
			System.out.println("Enter your rating (1-5):");
			int rating = sc.nextInt();
			sc.nextLine();
			addReview(courseId, review, rating);
		}
    }
    // Add review to the course
    public static void addReview(int courseId, String review, int rating) {
        String query = "INSERT INTO REVIEW_COUNT (COURSE_ID, REVIEW, RATING) VALUES (" + courseId + ", '" + review + "', " + rating + ")";
        Database db = new Database(); // Update with actual credentials
        db.insert(query);
        System.out.println("Review added successfully.");
    }
    public static void viewResult(int courseid ) {
    	String query = "SELECT * FROM REVIEW_COUNT WHERE COURSE_ID = "+courseid;
    	String review;
    	int rating;
    	try {
    		Database db = new Database();
        	db.rs = db.Select(query);
        	if(db.rs != null) {
        		System.out.println("Reviews\t\t\t\tRatings");
				while(db.rs.next()){
				    if (db.rs != null ) {
				    	review = db.rs.getString("REVIEW");
				    	rating = db.rs.getInt("RATING");
				    	System.out.println(review+"\t\t"+rating);
				    }
				}
				db.rs = db.Select("SELECT AVG(RATING) FROM REVIEW_COUNT WHERE COURSE_ID = "+courseid);
				if(db.rs.next()) {
					float avg = db.rs.getFloat("AVG(RATING)");
					System.out.println("Overall Rating: "+avg);
				}
				
			}
        	else {
        		System.out.println("No reviews Available");
        	}
    	}
    	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
