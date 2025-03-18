import java.time.LocalDate;

public class Admin extends Person {
    public Admin(String name, String personalIdentificationNumber, LocalDate birthDate,
                 String username, String password, String phoneNumber, String email) {
        super(name, personalIdentificationNumber, birthDate, username, password, phoneNumber, email);
    }

    // User Management
    public void createUser(String name, String personalIdentificationNumber, LocalDate birthDate,
                           String username, String password, String phoneNumber, String email) {
        Person newUser = new Person(name, personalIdentificationNumber, birthDate, username, password, phoneNumber, email);
        System.out.println("User " + username + " has been created.");
    }

    public void deleteUser(Person user) {
        System.out.println("User " + user.getUsername() + " has been deleted.");
    }

    public void modifyUser(Person user, String newUsername, String newPhoneNumber, String newEmail) {
        user.setUsername(newUsername);
        user.setPhoneNumber(newPhoneNumber);
        user.setEmail(newEmail);
        System.out.println("User " + newUsername + " has been modified.");
    }

    // System Maintenance
    public void performMaintenance() {
        System.out.println("System maintenance is being performed.");
    }

    // Overviews Big Transfers
    public void checkLargeTransaction(double amount) {
        if (amount > 10000) {
            System.out.println("Transaction of $" + amount + " flagged for review.");
        } else {
            System.out.println("Transaction of $" + amount + " is within normal limits.");
        }
    }

    // Manage AI Component
    public void overseeAIResponses() {
        System.out.println("AI response accuracy is being checked for compliance.");
    }

    // Update AI Training Data
    public void updateAITrainingData() {
        System.out.println("AI training data is being updated with the latest regulations and fraud detection models.");
    }
}