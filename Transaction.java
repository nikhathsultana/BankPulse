
import java.time.LocalDateTime;

public class Transaction {

    private TransactionType type;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(TransactionType type, double amount) {

        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public Transaction(TransactionType type, double amount, LocalDateTime timestamp) {

        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public void displayTransaction() {

        System.out.println("Type: " + type);
        System.out.println("Amount: " + amount);
        System.out.println("Date and Time: " + timestamp);
    }

    public TransactionType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
