import java.io.*;
import java.util.*;

public class BankY {
    public static void main(String[] args) {
        Bank bank = new Bank("BankY");

        
        bank.loadAccounts();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWelcome to " + bank.getName());
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View Account Statement");
            System.out.println("6. Add Interest");
            System.out.println("7. Admin Panel");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter account name: ");
                    String name = scanner.next();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    System.out.print("Set a password: ");
                    String password = scanner.next();
                    bank.createAccount(name, balance, password);
                    break;
                case 2:
                    System.out.print("Enter account name: ");
                    name = scanner.next();
                    System.out.print("Enter password: ");
                    password = scanner.next();
                    if (bank.authenticate(name, password)) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        bank.deposit(name, depositAmount);
                    } else {
                        System.out.println("Authentication failed.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account name: ");
                    name = scanner.next();
                    System.out.print("Enter password: ");
                    password = scanner.next();
                    if (bank.authenticate(name, password)) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        bank.withdraw(name, withdrawalAmount);
                    } else {
                        System.out.println("Authentication failed.");
                    }
                    break;
                case 4:
                    System.out.print("Enter source account name: ");
                    String fromAccount = scanner.next();
                    System.out.print("Enter source account password: ");
                    password = scanner.next();
                    if (bank.authenticate(fromAccount, password)) {
                        System.out.print("Enter destination account name: ");
                        String toAccount = scanner.next();
                        System.out.print("Enter transfer amount: ");
                        double transferAmount = scanner.nextDouble();
                        bank.transfer(fromAccount, toAccount, transferAmount);
                    } else {
                        System.out.println("Authentication failed.");
                    }
                    break;
                case 5:
                    System.out.print("Enter account name: ");
                    name = scanner.next();
                    System.out.print("Enter password: ");
                    password = scanner.next();
                    if (bank.authenticate(name, password)) {
                        bank.printAccountStatement(name);
                    } else {
                        System.out.println("Authentication failed.");
                    }
                    break;
                case 6:
                    bank.addInterest();
                    break;
                case 7:
                    System.out.print("Enter admin password: ");
                    password = scanner.next();
                    if (bank.authenticateAdmin(password)) {
                        bank.adminPanel();
                    } else {
                        System.out.println("Authentication failed.");
                    }
                    break;
                case 8:
                    // Save accounts to file
                    bank.saveAccounts();
                    System.out.println("Thank you for using " + bank.getName());
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

