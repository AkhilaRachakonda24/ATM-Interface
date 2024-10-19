import java.util.Scanner;

public class ATMSystem {
    private User user;
    private ATM atm;
    private Scanner scanner;

    public ATMSystem(User user) {
        this.user = user;
        this.atm = new ATM(user);
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        if (authenticateUser()) {
            displayMenu();
        } else {
            System.out.println("Authentication failed.");
        }
    }

    private boolean authenticateUser() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String userPin = scanner.nextLine();
        return user.authenticate(userId, userPin);
    }

    private void displayMenu() {
        int choice;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.showTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    atm.showBalance();
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    atm.showBalance();
                    break;
                case 4:
                    System.out.print("Enter recipient's User ID: ");
                    String recipientId = scanner.next();
                    System.out.print("Enter amount to transfer: ");
                    double transferAmount = scanner.nextDouble();
                    // In a real system, we'd look up the recipient's account details here
                    User recipient = new User(recipientId, "0000", 0); // Dummy recipient
                    atm.transfer(transferAmount, recipient);
                    atm.showBalance();
                    break;
                case 5:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
