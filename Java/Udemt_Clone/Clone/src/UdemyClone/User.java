package UdemyClone;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User extends Course{
	private int User_id;
    private String name;
    private String email;
    private String password;
    private int course_count;
    public Database db = new Database();
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    
    public void register() {
        String query = "INSERT INTO USERS (NAME, EMAIL, PASSWORD, COURSE_COUNT) VALUES ('" + name + "', '" + email + "', '" + password + "', 0)";
        if(db.insert(query)) {
        	System.out.println("Registration successful!");
        }
        else {
            System.out.println("Registration failed.");
        }
    }

    
    public boolean login(String email, String password) {
        String query = "SELECT * FROM USERS WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "'";
        db.rs = db.Select(query);
        try {
            if (db.rs != null && db.rs.next()) {
            	name = db.rs.getString("NAME");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return false;
    }
    
    
    public int getUserId() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM USERS WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "';";
        db.rs = db.Select(query);
        try {
            if (db.rs != null && db.rs.next()) {
            	User_id = db.rs.getInt("USER_ID");
                return User_id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
	}
    
    
    public String getName(String email, String password) {
        String query = "SELECT * FROM USERS WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "';";
        // Update with actual credentials
        db.rs = db.Select(query);
        try {
            if (db.rs != null && db.rs.next()) {
            	name = db.rs.getString("NAME");
                return name;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public String getEmail() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM USERS WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "';";
        // Update with actual credentials
        db.rs = db.Select(query);
        try {
            if (db.rs != null && db.rs.next()) {
            	email = db.rs.getString("EMAIL");
                return email;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
	}
    
    
    public int getCourseCount() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM USERS WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "';";
         // Update with actual credentials
        db.rs = db.Select(query);
        try {
            if (db.rs != null && db.rs.next()) {
            	course_count = db.rs.getInt("COURSE_COUNT");
                return course_count;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
	}
    
    
    public String getPassword() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM USERS WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "';";
         // Update with actual credentials
        db.rs = db.Select(query);
        try {
            if (db.rs != null && db.rs.next()) {
            	password = db.rs.getString("PASSWORD");
                return password;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
	}
    
    
    public void my_courses(User currentUser) {
    	if( currentUser.getUserId()>0) {
	    	String query = "SELECT * FROM USER_COURSE WHERE USER_ID = " + currentUser.getUserId();
	        ResultSet rs = db.Select(query);
	        try {
	            while (rs.next()) {
	                System.out.println("Course Title: " + rs.getString("TITLE"));
	                System.out.println("Completion Status: " + rs.getInt("COMPLETE_NESS") + "%");
	                System.out.println("Date of Purchase: " + rs.getDate("BUY_DATE"));
	                System.out.println("-------------------------------");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
    	}
    }
}
