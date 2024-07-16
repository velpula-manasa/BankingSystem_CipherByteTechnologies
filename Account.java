import java.io.Serializable;
import java.util.*;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private double balance;
    private String password;
    private List<String> transactions;

    public Account(String name, double initialBalance, String password) {
        this.name = name;
        this.balance = initialBalance;
        this.password = password;
        this.transactions = new ArrayList<>();
        addTransaction("Account created with balance: " + initialBalance);
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposited: " + amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdrew: " + amount);
            return true;
        }
        return false;
    }

    public void addInterest(double rate) {
        double interest = balance * rate;
        balance += interest;
        addTransaction("Interest added: " + interest);
    }

    public void printStatement() {
        System.out.println("Account Statement for " + name + ":");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    private void addTransaction(String detail) {
        transactions.add(detail);
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    @Override
    public String toString() {
        return "Account{name='" + name + "', balance=" + balance + '}';
    }
}

