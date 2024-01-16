package accounts;

public class Administrator extends User {
    private String username;
    private String role;
    private String password;

    public Administrator(String userId, String firstName, String lastName, String address, String phone,
                         String username, String role, String password) {
        super(userId, firstName, lastName, address, phone);
        this.username = username;
        this.role = role;
        this.password = password;
    }

    // Getters and setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}