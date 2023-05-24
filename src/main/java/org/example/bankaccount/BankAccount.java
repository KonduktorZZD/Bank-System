package org.example.bankaccount;

import org.example.exceptions.InsufficientFundsException;
import org.example.exceptions.TransferFundsException;
import org.example.transaction.TransactionType;

public interface BankAccount {
    String getAccountOwnerName();

    String getAccountNumber();

    double getAccountBalance();

    AccountType getAccountType();
    //Metody do wpłaty, wypłaty i transferu pieniędzy

    void deposit(double amountMoney) throws InsufficientFundsException;

    void withdraw(double amountMoney) throws InsufficientFundsException;

    void transfer(String destinationNumberAccount, double amountMoney) throws TransferFundsException;
    //Metody do generacji numeru konta bankowego
    String generateAccountNumber();
    int computeChecksum(String accountNumber);

}
