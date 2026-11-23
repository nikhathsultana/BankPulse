import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {

            System.out.println("\n===== BANKPULSE BANKING SYSTEM =====");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. List Accounts");
            System.out.println("5. Exit");

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
                    String name = sc.nextLine();

                    Account newAccount = bank.openAccount(name);

                    System.out.println("Account created successfully!");
                    System.out.println("Account Number: "
                            + newAccount.getAccountNumber());
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int depositNumber = Integer.parseInt(sc.nextLine());

                    Account depositAccount =
                            bank.findAccount(depositNumber);

                    if (depositAccount == null) {
                        System.out.println("Account not found.");
                        break;
                    }

                    System.out.print("Enter deposit amount: ");
                    double depositAmount =
                            Double.parseDouble(sc.nextLine());

                    if (depositAccount.deposit(depositAmount)) {
                        System.out.println("Deposit successful!");
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int withdrawNumber = Integer.parseInt(sc.nextLine());

                    Account withdrawAccount =
                            bank.findAccount(withdrawNumber);

                    if (withdrawAccount == null) {
                        System.out.println("Account not found.");
                        break;
                    }

                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount =
                            Double.parseDouble(sc.nextLine());

                    if (withdrawAccount.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println(
                                "Withdrawal rejected. Check amount and balance."
                        );
                    }
                    break;

                case 4:
                    System.out.println("\n===== ACCOUNT DETAILS =====");
                    bank.listAccounts();
                    break;

                case 5:
                    System.out.println("Thank you for using BankPulse!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}