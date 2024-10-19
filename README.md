# MainATMApp
public class MainATMApp {
    public static void main(String[] args) {
        // Creating a sample user with ID: "user123" and PIN: "1234" and an initial balance of 1000
        User user = new User("user123", "1234", 1000.0);

        // Starting the ATM System
        ATMSystem atmSystem = new ATMSystem(user);
        atmSystem.start();
    }
}
