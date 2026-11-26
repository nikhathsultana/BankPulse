import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts = new ArrayList<>();

    public Bank() {
    
    }
    
    private int nextAccountNumber = 1001;

        public Bank(List<Account> accounts) {
        this.accounts = accounts;

        for (Account account : accounts) {
            if (account.getAccountNumber() >= nextAccountNumber) {
                nextAccountNumber = account.getAccountNumber() + 1;
            }
        }
    }

    public Account openAccount(String name) {

        Account account = new Account(nextAccountNumber, name);

        accounts.add(account);

        nextAccountNumber++;

        return account;
    }

    public Account findAccount(int accountNumber) {

        for (Account account : accounts) {

            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }

    
    public void listAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        System.out.println("\n===== ACCOUNT HOLDERS =====");

        for (Account account : accounts) {
            System.out.println("- " + account.getHolderName());
        }
    }


    public List<Account> getAccounts() {
        return accounts;
    }
}