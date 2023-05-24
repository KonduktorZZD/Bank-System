package org.example.bankaccount;

import org.example.bankaccount.AbstractAccount;

import java.util.ArrayList;

public class AccountList {
     ArrayList<AbstractAccount> accountsNumberList;

    public AccountList(){
        accountsNumberList = new ArrayList<>();
    }

    public void addAccountToList(AbstractAccount account){
        accountsNumberList.add(account);
    }

    public void showAllAccounts(){
        int counter = 1;
        for(AbstractAccount account : accountsNumberList){
            System.out.println(counter+ ". Typ konta: " + account.getAccountType() + ", Właściciel konta: " + account.getAccountOwnerName() +
                    ", Numer konta: " + account.getAccountNumber() + ", Saldo: " + account.getAccountBalance());
        }
    }

    public boolean accountNumberIsExist(String accountNumber){
        for(AbstractAccount account : accountsNumberList){
            if(account.getAccountNumber() == accountNumber){
                return true;
            }
        }
        return false;
    }
}
