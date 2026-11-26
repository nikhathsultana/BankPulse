
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FileStorage storage = new FileStorage();

        Bank bank = new Bank(storage.loadAccounts("accounts.txt"));

        while (true) {

            System.out.println("\n========== BANKPULSE ==========");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. List All Accounts");
            System.out.println("5. View Account Details");
            System.out.println("6. View Transaction History");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter account holder name: ");
                    String name = sc.nextLine().trim();

                    if (name.isEmpty() || name.contains(",")) {
                        System.out.println("Please enter a valid name without commas.");
                        break;
                    }

                    Account newAccount = bank.openAccount(name);

                    System.out.println("Account created successfully!");
                    System.out.println("Account Number: "
                            + newAccount.getAccountNumber());
                    break;

                case 2:
                    System.out.print("Enter account number: ");

                    try {
                        int depositNumber = Integer.parseInt(sc.nextLine());

                        Account depositAccount = bank.findAccount(depositNumber);

                        if (depositAccount == null) {
                            System.out.println("Account not found.");
                            break;
                        }

                        System.out.print("Enter deposit amount: ");
                        double depositAmount = Double.parseDouble(sc.nextLine());

                        if (depositAccount.deposit(depositAmount)) {
                            System.out.println("Deposit successful!");
                            System.out.println("Updated Balance: ₹"
                                    + depositAccount.getBalance());
                        } else {
                            System.out.println("Invalid deposit amount.");
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Please enter valid numeric values.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");

                    try {
                        int withdrawNumber = Integer.parseInt(sc.nextLine());

                        Account withdrawAccount = bank.findAccount(withdrawNumber);

                        if (withdrawAccount == null) {
                            System.out.println("Account not found.");
                            break;
                        }

                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = Double.parseDouble(sc.nextLine());

                        if (withdrawAccount.withdraw(withdrawAmount)) {
                            System.out.println("Withdrawal successful!");
                            System.out.println("Updated Balance: ₹"
                                    + withdrawAccount.getBalance());
                        } else {
                            System.out.println(
                                    "Withdrawal rejected. Check amount and balance."
                            );
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Please enter valid numeric values.");
                    }
                    break;

                case 4:
                    System.out.println("\n===== ALL ACCOUNTS =====");
                    bank.listAccounts();
                    break;

                case 5:
                    System.out.print("Enter account number: ");

                    try {
                        int accountNumber = Integer.parseInt(sc.nextLine());

                        Account account = bank.findAccount(accountNumber);

                        if (account == null) {
                            System.out.println("Account not found.");
                        } else {
                            account.displayAccountDetails();
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid account number.");
                    }
                    break;

                case 6:
                    System.out.print("Enter account number: ");

                    try {
                        int statementNumber = Integer.parseInt(sc.nextLine());

                        Account statementAccount = bank.findAccount(statementNumber);

                        if (statementAccount == null) {
                            System.out.println("Account not found.");
                        } else {
                            statementAccount.printStatement();
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid account number.");
                    }
                    break;

                case 7:
                    storage.saveAccounts(bank.getAccounts(), "accounts.txt");

                    System.out.println("Thank you for using BankPulse!");

                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
