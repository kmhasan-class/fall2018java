package bankaccountui;

import java.time.LocalDate;

public class BankAccount {
    private int id;
    private Client client;
    private double balance;
   
    // copy constructor
    public BankAccount(BankAccount that) {
        this.id = that.id;
        this.client = new Client(that.client.getId(),
                new Name(that.client.getName().getFirstName(),
                    that.client.getName().getLastName()),
                LocalDate.of(that.client.getDob().getYear(), 
                        that.client.getDob().getMonth(), 
                        that.client.getDob().getDayOfMonth())
        );
        this.balance = that.balance;
    }
    
    public BankAccount(int id, Client client) {
        this.id = id;
        this.client = client;
        balance = 0;
    }

    public BankAccount(int id, Client client, double balance) {
        this.id = id;
        this.client = client;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public double getBalance() {
        return balance;
    }
    
    public void withdraw(double amount) {
        if (amount <= balance && amount > 0)
            balance = balance - amount;
    }
    
    public void deposit(double amount) {
        if (amount > 0)
            balance = balance + amount;
    }
}
