public class Account {

    private int accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public Account(int accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 0.0;
    }

    // Deposit money
    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance = balance + amount;
        return true;
    }

    // Withdraw money
    public boolean withdraw(double amount) {

        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance = balance - amount;
        return true;
    }

    // Display account details
    public void displayAccount() {

        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + String.format("%.2f", balance));
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}