package bankaccountui.account;

import bankaccountui.Client;

public class CurrentAccount2 extends BankAccount {
    public CurrentAccount2(int id, Client client, double balance) {
        super(id, client, balance);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount * 1.01);
    }
}
