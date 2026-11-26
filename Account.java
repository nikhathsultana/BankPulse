
import java.util.ArrayList;
import java.util.List;

public class Account {

    private int accountNumber;
    private String holderName;
    private double balance;

    // Stores all transactions belonging to this account
    private List<Transaction> transactions = new ArrayList<>();

    // Constructor for creating a new account
    public Account(int accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 0.0;
    }

    // Constructor for restoring an existing account
    public Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Deposit money
    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance = balance + amount;

        transactions.add(
            new Transaction(TransactionType.DEPOSIT, amount)
        );

        return true;
    }

    // Withdraw money
    public boolean withdraw(double amount) {

        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance = balance - amount;

        transactions.add(
            new Transaction(TransactionType.WITHDRAWAL, amount)
        );

        return true;
    }

    // Display account details
    public void displayAccountDetails() {

        System.out.println("\n----- Account Details -----");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + holderName);
        System.out.println("Current Balance: ₹" + String.format("%.2f", balance));
    }

    // Display account 
    public void displayAccount() {
        displayAccountDetails();
    }

    // Display transaction history
    public void printStatement() {

        displayAccountDetails();

        System.out.println("\n----- Transaction History -----");

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (Transaction transaction : transactions) {
            transaction.displayTransaction();
            System.out.println("---------------------");
        }
    }

    // Getter methods
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Used by FileStorage to restore old transactions
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
