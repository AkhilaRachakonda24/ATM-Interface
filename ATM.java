import java.util.ArrayList;
import java.util.List;

public class ATM {
    private User user;
    private List<Transaction> transactionHistory;

    public ATM(User user) {
        this.user = user;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        user.setBalance(user.getBalance() + amount);
        transactionHistory.add(new Transaction("Deposit", amount));
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) {
        if (user.getBalance() >= amount) {
            user.setBalance(user.getBalance() - amount);
            transactionHistory.add(new Transaction("Withdraw", amount));
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void transfer(double amount, User recipient) {
        if (user.getBalance() >= amount) {
            user.setBalance(user.getBalance() - amount);
            recipient.setBalance(recipient.getBalance() + amount);
            transactionHistory.add(new Transaction("Transfer", amount));
            System.out.println("Transferred: $" + amount + " to " + recipient.getUserId());
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Transaction transaction : transactionHistory) {
                System.out.println(transaction.getTransactionDetails());
            }
        }
    }

    public void showBalance() {
        System.out.println("Current balance: $" + user.getBalance());
    }
}
