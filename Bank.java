import java.io.*;
import java.util.*;

public class Bank {
    private String name;
    private Map<String, Account> accounts;
    private static final String FILE_NAME = "accounts.txt";
    private static final double INTEREST_RATE = 0.03;
    private static final String ADMIN_PASSWORD = "admin123";

    public Bank(String name) {
        this.name = name;
        this.accounts = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void createAccount(String name, double initialBalance, String password) {
        if (accounts.containsKey(name)) {
            System.out.println("Account already exists.");
            return;
        }
        accounts.put(name, new Account(name, initialBalance, password));
        System.out.println("Account created successfully.");
    }

    public void deposit(String name, double amount) {
        Account account = accounts.get(name);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String name, double amount) {
        Account account = accounts.get(name);
        if (account != null) {
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful. Remaining balance: " + account.getBalance());
            } else {
                System.out.println("Insufficient funds. Current balance: " + account.getBalance());
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void transfer(String fromName, String toName, double amount) {
        Account fromAccount = accounts.get(fromName);
        Account toAccount = accounts.get(toName);
        if (fromAccount != null && toAccount != null) {
            if (fromAccount.withdraw(amount)) {
                toAccount.deposit(amount);
                System.out.println("Transfer successful. Remaining balance in " + fromName + ": " + fromAccount.getBalance());
            } else {
                System.out.println("Insufficient funds in " + fromName + ". Current balance: " + fromAccount.getBalance());
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    public void printAccountStatement(String name) {
        Account account = accounts.get(name);
        if (account != null) {
            account.printStatement();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void addInterest() {
        for (Account account : accounts.values()) {
            account.addInterest(INTEREST_RATE);
        }
        System.out.println("Interest added to all accounts.");
    }

    public void adminPanel() {
        System.out.println("Admin Panel:");
        for (Account account : accounts.values()) {
            System.out.println(account);
        }
    }

    public boolean authenticate(String name, String password) {
        Account account = accounts.get(name);
        return account != null && account.authenticate(password);
    }

    public boolean authenticateAdmin(String password) {
        return ADMIN_PASSWORD.equals(password);
    }

    public void saveAccounts() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(accounts);
            System.out.println("Accounts saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadAccounts() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            accounts = (HashMap<String, Account>) in.readObject();
            System.out.println("Accounts loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }
}

