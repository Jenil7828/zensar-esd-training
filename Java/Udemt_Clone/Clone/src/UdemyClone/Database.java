package UdemyClone;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Database {
	String url; // Replace with your database URL
    String user; // Replace with your database username
    String password; // Replace with your database password
    private Connection connection;
    private Statement statement;
    ResultSet rs;
    // JDBC variables for opening, closing, and managing resources
    @SuppressWarnings("finally")
	public Database(){
    	this.url = "jdbc:mysql://localhost:3306/udemy";
    	this.user = "root";
    	this.password = "Jenil_7828";
	    try {
	        // Registering the MySQL JDBC driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        // Establishing the connection
	        connection = DriverManager.getConnection(this.url, this.user, this.password);
	        // Creating a statement object to execute queries
	        statement = connection.createStatement();
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    } 
	    finally
	    {
	    return;	
	    }
	    
    }
    
    public void update(String query) {
        try {
            statement.executeUpdate(query);
            System.out.println("Record Updated Succesfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    public boolean insert(String query) {
    	boolean exceptionOccurred = false;
        try {
            if(statement != null) {
            	statement.executeUpdate(query);
            
            	System.out.println("Record Inserted Succesfully...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }if (!exceptionOccurred) {
            System.out.println("No exception occurred, continue with normal flow.");
            return true;
        } else {
            System.out.println("Exception was caught.");
            return false;
        }
        
    }
    public ResultSet Select(String query ) {
        try {
        	rs = statement.executeQuery(query);
            return rs; // Returning ResultSet
        } catch (SQLException e) {
            System.out.println("Query Execution Failed: " + e.getMessage());
            return null;
        }
    }
    public int delete(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public void closeConnection() {
        try {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
            System.out.println("Database Connection Closed.");
        } catch (Exception e) {
            System.out.println("Failed to Close Connection: " + e.getMessage());
        }
    }

}
