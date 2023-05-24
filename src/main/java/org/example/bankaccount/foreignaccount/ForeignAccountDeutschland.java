package org.example.bankaccount.foreignaccount;

import org.example.bankaccount.AbstractAccount;
import org.example.bankaccount.AccountType;

public class ForeignAccountDeutschland extends AbstractAccount {
    private final AccountType accountType;
    public ForeignAccountDeutschland(String accountOwnerName, double startBalance, AccountType accountType){
        super(accountOwnerName, startBalance);
        this.accountType = accountType;
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.FOREIGN_DEUTSCHLAND;
    }
}
