import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts = new ArrayList<>();

    private int nextAccountNumber = 1001;

    // Open a new account
    public Account openAccount(String name) {

        Account account = new Account(nextAccountNumber, name);

        accounts.add(account);

        nextAccountNumber++;

        return account;
    }

    // Find an account
    public Account findAccount(int accountNumber) {

        for (Account account : accounts) {

            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }

    // List all accounts
    public void listAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        for (Account account : accounts) {

            account.displayAccount();

            System.out.println("--------------------");
        }
    }
}