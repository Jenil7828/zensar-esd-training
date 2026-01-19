package day18;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

	public class JDBCExample {
	    public static void main(String[] args) {
	        // JDBC URL, username, and password of MySQL server
	        String url = "jdbc:mysql://localhost:3306/udemy"; // Replace with your database URL
	        String user = "root"; // Replace with your database username
	        String password = "root"; // Replace with your database password

	        // JDBC variables for opening, closing, and managing resources
	        Connection connection = null;
	        Statement statement = null;

	        try {
	            // Registering the MySQL JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // Establishing the connection
	            connection = DriverManager.getConnection(url, user, password);
	            System.out.println("Connected to the MySQL database!");

	            // Creating a statement object to execute queries
	            statement = connection.createStatement();
	            Scanner scan = new Scanner(System.in);
	            String n = scan.next();
	            String e = scan.next();
	            String p = scan.next();
	            int c = scan.nextInt();
	            // Executing a query
	            String query = "INSERT INTO USERS (NAME, EMAIL, PASSWORD, COURSE_COUNT)VALUES ('"+n+"', '"+ e+"' ,'"+p+"' ,"+c+");";
	            System.out.println(query);
	           
	            statement.executeUpdate(query);
	        
	            query = "SELECT * FROM USERS;";
	            ResultSet resultSet = statement.executeQuery(query);
	            

	            // Processing the result set
	            while (resultSet.next()) {
	                int user_id = resultSet.getInt("user_id");
	                String name = resultSet.getString("name");
	                String email = resultSet.getString("email");
	                String pass = resultSet.getString("password");
	                int course = resultSet.getInt("course_count");
	                System.out.println("USER_ID: " + user_id + ", Name: " + name +",  E-mail: "+ email+ ", Password: "+pass+", Course Count: "+course);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Closing resources
	            try {
	                if (statement != null) statement.close();
	                if (connection != null) connection.close();
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	    }
	}
