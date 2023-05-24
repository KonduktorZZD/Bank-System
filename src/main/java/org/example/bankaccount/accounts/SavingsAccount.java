package org.example.bankaccount.accounts;

import org.example.bankaccount.AbstractAccount;
import org.example.bankaccount.AccountType;

public class SavingsAccount extends AbstractAccount {
    private static AccountType accountType;
    public SavingsAccount(String accountOwnerName, double startBalance, AccountType accountType){
        super(accountOwnerName, startBalance);
        this.accountType = accountType;
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.SAVINGS;
    }
}
