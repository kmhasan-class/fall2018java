/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountui.account;

import bankaccountui.Client;
import bankaccountui.Client;
import bankaccountui.account.BankAccount;

/**
 *
 * @author kmhasan
 */
public class CreditCard extends BankAccount {
    private double creditLimit;
    
    public CreditCard(int id, Client client, double creditLimit) {
        super(id, client);
        this.creditLimit = creditLimit;
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount > 0 &&
                amount <= balance + creditLimit)
            balance = balance - amount;
    }
    
    @Override // annotation
    public String toString() {
        //return String.format("%s;%.2f", super.toString(), creditLimit);
        return String.format("%d;%.2f;%.2f", 
                this.getId(),
                this.getBalance(),
                this.creditLimit
                );
    }
}
