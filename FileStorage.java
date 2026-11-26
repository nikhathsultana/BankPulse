import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FileStorage {

    public void saveAccounts(List<Account> accounts, String path) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            for (Account account : accounts) {

                writer.write("ACCOUNT," + account.getAccountNumber() + ","
                        + account.getHolderName() + ","
                        + account.getBalance());

                writer.newLine();

                for (Transaction transaction : account.getTransactions()) {

                    writer.write("TRANSACTION," + account.getAccountNumber() + ","
                            + transaction.getType() + ","
                            + transaction.getAmount() + ","
                            + transaction.getTimestamp());

                    writer.newLine();
                }
            }

            System.out.println("Bank data saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving bank data: " + e.getMessage());
        }
    }

    public List<Account> loadAccounts(String path) {

        Map<Integer, Account> accountMap = new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line;

            while ((line = reader.readLine()) != null) {

                try {
                    String[] data = line.split(",", 5);

                    if (data[0].equals("ACCOUNT")) {

                        int accountNumber = Integer.parseInt(data[1]);
                        String name = data[2];
                        double balance = Double.parseDouble(data[3]);

                        Account account = new Account(accountNumber, name, balance);

                        accountMap.put(accountNumber, account);

                    } else if (data[0].equals("TRANSACTION")) {

                        int accountNumber = Integer.parseInt(data[1]);

                        Account account = accountMap.get(accountNumber);

                        if (account != null) {

                            TransactionType type = TransactionType.valueOf(data[2]);
                            double amount = Double.parseDouble(data[3]);
                            LocalDateTime timestamp = LocalDateTime.parse(data[4]);

                            Transaction transaction =
                                    new Transaction(type, amount, timestamp);

                            account.addTransaction(transaction);
                    }

                }

                } catch (RuntimeException e) {
                    System.out.println("Skipping invalid record: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("No saved data found. Starting with an empty bank.");
        }

        return new ArrayList<>(accountMap.values());
    }

}