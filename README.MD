# BankPulse – Java Banking System

BankPulse is a beginner-friendly console-based banking application developed using Java. It allows users to create bank accounts, deposit and withdraw money, view account information, and track transaction history.

The application also uses file handling to save account information and transaction records, allowing data to remain available even after the program is closed.

## Features

- **Open Account:** Create a new bank account with an automatically generated account number.
- **Deposit Money:** Deposit money into an existing account.
- **Withdraw Money:** Withdraw money while checking the available balance.
- **List All Accounts:** View the names of all account holders.
- **View Account Details:** View account information using the account number.
- **Transaction History:** View deposits and withdrawals along with their timestamps.
- **Data Persistence:** Automatically save account details and transaction history to a file when exiting the application.
- **Data Restoration:** Load previously saved account information when the application starts.

## Technologies Used

- Java (JDK 21)
- Visual Studio Code
- Java Collections Framework
- File Handling
- Java Time API

## Project Structure

```text
BankPulse/
│
├── Account.java
├── Bank.java
├── Main.java
├── Transaction.java
├── TransactionType.java
├── FileStorage.java
├── accounts.txt
└── README.md
```

`accounts.txt` is generated automatically when the application saves its data.

## Concepts Practiced

- Object-Oriented Programming (OOP)
- Classes and Objects
- Encapsulation
- Constructors and Method Overloading
- Enums
- Composition
- ArrayList and List
- HashMap / LinkedHashMap
- File I/O
- Exception Handling
- LocalDateTime

## How to Run

1. Clone the repository:

```bash
git clone https://github.com/nikhathsultana/BankPulse.git
```

2. Navigate to the project directory:

```bash
cd BankPulse
```

3. Compile the Java files:

```bash
javac *.java
```

4. Run the application:

```bash
java Main
```

## Data Storage

BankPulse uses file handling to store account details, balances, and transaction records in `accounts.txt`.

- Existing accounts are loaded when the application starts.
- Successful deposits and withdrawals are recorded in transaction history.
- Account information and transactions are saved when the user exits the application.
- Previously saved transaction timestamps are restored when the application runs again.

## Learning Outcome

Through this project, I gained practical experience in Java programming, object-oriented design, composition between classes, collections, enums, and file handling. I also learned how to maintain transaction history and preserve application data between program executions.

## Future Enhancements

- Fund transfers between accounts.
- Admin authentication and account management.
- Improved data validation and secure storage.
- Database integration.

---

**Project:** BankPulse  
**Language:** Java  
**Level:** Beginner+
