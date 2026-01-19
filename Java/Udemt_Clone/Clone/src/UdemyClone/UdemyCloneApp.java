package UdemyClone;

import java.util.Scanner;

public class UdemyCloneApp {
	static String usr;
	static User currentUser = null;
	static Course c = new Course();
	public Database d = new Database();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        
     // Introduction message for the user
        System.out.println("Welcome to Udemy Clone Application!");
        System.out.println();
        System.out.println("This is your personal learning platform where you can:");
        System.out.println("- Register and create your account");
        System.out.println("- Login and access your courses");
        System.out.println( "- Browse and purchase online courses from a variety of topics");
        System.out.println("- Add reviews for courses you've completed");
        System.out.println("- Track and manage your purchased courses");
        System.out.println();
        System.out.println("Ready to start your learning journey? Let's go!" );
        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. View Courses");
            System.out.println("4. View Reviews and Ratings");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter your name:");
                    String name = sc.nextLine();
                    System.out.print("Enter your email:");
                    String email = sc.next();
                    System.out.print("Enter your password:");
                    String password = sc.next();
                    User newUser = new User(name, email, password);
                    newUser.register();
                    currentUser = newUser;
                    usr = name;
                    break;
                case 2:
                	System.out.print("Enter your name:");
                    name = sc.nextLine();
                    System.out.print("Enter your email:");
                    email = sc.next();
                    System.out.print("Enter your password:");
                    password = sc.next();
                    User loginUser = new User(name, email, password);
                    if (loginUser.login(email, password)) {
                        System.out.println("Login successful!");
                        usr = loginUser.getName(email, password);
                        currentUser = loginUser;
                        // After login, display course or make payment options available
                    } else {
                        System.out.println("Invalid email or password.");
                        break;
                    }
                    do {
                        System.out.println("\nMain Menu:");
                        
                        System.out.println("1. My Courses");
                        System.out.println("2. Buy Course");
                        System.out.println("3. Add Review");
                        System.out.println("4. Exit");
                        System.out.print("Enter your choice: ");
                        choice = sc.nextInt();
                        sc.nextLine(); // Consume newline character

                        switch (choice) {
                            case 1:
                                if (usr != null) {
                                    loginUser.my_courses(loginUser);
                                } else {
                                    System.out.println("Please log in first.");
                                }
                                break;
                            case 2:
                                if (currentUser != null) {
                                	c.displayCourseDetails();
                                	System.out.print("Enter the course ID you want to purchase:");
                                    int courseId = sc.nextInt();
                                    sc.nextLine(); // Consume newline character
                                    System.out.print("Enter payment method (Credit/Debit Card, Net Banking, UPI):");
                                    String paymentMode = sc.nextLine();
                                    System.out.print("Enter discount (if any):");
                                    String discount = sc.nextLine();
                                    c.buy_course(currentUser, courseId, paymentMode, discount);
                                } else {
                                    System.out.println("Please log in first.");
                                }
                                break;
                            case 3:
                                if (currentUser != null) {
                                    Review.review();
                                } else {
                                    System.out.println("Please log in first.");
                                }
                                break;
                            case 4:
                                System.out.println("Exiting the application. Goodbye!");
                                currentUser = null;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (choice != 4);
               
                    break;
    			case 3:
    				c.displayCourseDetails();
    				break;
    			case 4:
    				c.displayCourseDetails();
    				System.out.println("Enter you want to see the reviews of: ");
    				int cours = sc.nextInt();
    				sc.nextLine();
    				Review.viewResult(cours);
    				System.out.println("\nPress Enter to return to the menu...");
    			    sc.nextLine();
    			    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        System.out.println("Exited Successfully");
        sc.close();
    }
}
