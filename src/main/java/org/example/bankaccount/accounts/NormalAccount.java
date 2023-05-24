package org.example.bankaccount.accounts;

import org.example.bankaccount.AbstractAccount;
import org.example.bankaccount.AccountType;

public class NormalAccount extends AbstractAccount {
    private final AccountType accountType;
    public NormalAccount(String accountOwnerName, double startBalance, AccountType accountType){
        super(accountOwnerName, startBalance);
        this.accountType = accountType;
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.NORMAL;
    }
}
