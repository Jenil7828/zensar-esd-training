package UdemyClone;


public abstract class UserBase {
    private String userId;
    private String name;
    private String email;

    // Constructor
    public UserBase(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    // Getter methods (Encapsulation)
    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Abstract method to define in subclasses
    public abstract void displayUserDetails();
}

