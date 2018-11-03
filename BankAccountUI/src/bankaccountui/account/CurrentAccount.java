package bankaccountui.account;

import bankaccountui.Client;
import bankaccountui.Name;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CurrentAccount {
    private int id;
    private Client client;
    private double balance;
    private LocalDateTime accountCreationDateTime;
   
    // copy constructor
    public CurrentAccount(CurrentAccount that) {
        this.id = that.id;
        this.client = new Client(that.client.getId(),
                new Name(that.client.getName().getFirstName(),
                    that.client.getName().getLastName()),
                LocalDate.of(that.client.getDob().getYear(), 
                        that.client.getDob().getMonth(), 
                        that.client.getDob().getDayOfMonth())
        );
        this.balance = that.balance;
        this.accountCreationDateTime = 
                LocalDateTime.of(
                        that.accountCreationDateTime.getYear(),
                        that.accountCreationDateTime.getMonth(), 
                        that.accountCreationDateTime.getDayOfMonth(), 
                        that.accountCreationDateTime.getHour(), 
                        that.accountCreationDateTime.getMinute(), 
                        that.accountCreationDateTime.getSecond()
                );        
    }
    
    public CurrentAccount(int id, Client client) {
        this.id = id;
        this.client = client;
        balance = 0;
        this.accountCreationDateTime = LocalDateTime.now();
    }

    public CurrentAccount(int id, Client client, double balance) {
        this.id = id;
        this.client = client;
        this.balance = balance;
        this.accountCreationDateTime = LocalDateTime.now();
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
        amount = amount * 1.01;
        if (amount <= balance && amount > 0)
            balance = balance - amount;
    }
    
    public void deposit(double amount) {
        if (amount > 0)
            balance = balance + amount;
    }

    public String toString() {
        return String.format("%d;%s;%.2f;%s",
                id, client, balance, accountCreationDateTime);
    }    
}
