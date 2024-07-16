BankY Management System
Overview

BankY Management System is a console-based banking application written in Java. It provides basic banking functionalities like creating accounts, depositing and withdrawing money, transferring funds between accounts, viewing account statements, and adding interest. The application also includes an admin panel for viewing all accounts and supports data persistence using serialization to save and load account data.
Features

    Create new accounts with an initial balance and a password.
    Deposit and withdraw funds from accounts.
    Transfer funds between accounts.
    View account statements with a transaction history.
    Add interest to all accounts.
    Admin panel to view all accounts.
    Authentication for users and admin.
    Data persistence to save and load accounts from a file.

Structure

The project consists of the following Java classes:

    Account: Represents a bank account with basic functionalities.
    Bank: Manages multiple accounts and provides banking operations.
    BankY: The main class that provides the user interface for interacting with the bank.

Getting Started
Prerequisites

    Java Development Kit (JDK) installed.
    An IDE or text editor for Java development.

Running the Program

    Clone the Repository:

    sh

git clone https://github.com/your-repo/bank-management-system.git

Navigate to the Project Directory:

sh

cd bank-management-system

Compile the Java Files:

sh

javac Account.java Bank.java BankY.java

Run the Main Class:

sh

    java BankY

Usage
Main Menu

When you run the program, you will see the following menu:

markdown

Welcome to BankY
1. Create Account
2. Deposit
3. Withdraw
4. Transfer
5. View Account Statement
6. Add Interest
7. Admin Panel
8. Exit
Choose an option: 

Options

    Create Account:
        Enter the account name, initial balance, and a password to create a new account.

    Deposit:
        Enter the account name and password to authenticate.
        Enter the amount to deposit into the account.

    Withdraw:
        Enter the account name and password to authenticate.
        Enter the amount to withdraw from the account.

    Transfer:
        Enter the source account name and password to authenticate.
        Enter the destination account name and the amount to transfer.

    View Account Statement:
        Enter the account name and password to authenticate.
        View the transaction history of the account.

    Add Interest:
        Add a predefined interest rate (3%) to all accounts.

    Admin Panel:
        Enter the admin password to authenticate.
        View all accounts and their details.

    Exit:
        Save all account data to a file.
        Exit the program.

Data Persistence

    The application saves account data to a file named accounts.txt using serialization.
    On startup, the application loads account data from this file if it exists.

Saving Accounts

java

bank.saveAccounts();

    This method serializes the accounts map and writes it to the file accounts.txt.

Loading Accounts

java

bank.loadAccounts();

    This method reads the serialized data from the file accounts.txt and loads it into the accounts map.

Example Output

markdown

Welcome to BankY
1. Create Account
2. Deposit
3. Withdraw
4. Transfer
5. View Account Statement
6. Add Interest
7. Admin Panel
8. Exit
Choose an option: 1
Enter account name: John
Enter initial balance: 1000
Set a password: pass123
Account created successfully.

Welcome to BankY
1. Create Account
2. Deposit
3. Withdraw
4. Transfer
5. View Account Statement
6. Add Interest
7. Admin Panel
8. Exit
Choose an option: 2
Enter account name: John
Enter password: pass123
Enter deposit amount: 500
Deposit successful. New balance: 1500.0

License

This project is open-source and available under the MIT License.

Feel free to modify the code to suit your needs or contribute to the project by submitting pull requests. If you encounter any issues or have suggestions for improvement, please open an issue on GitHub.
