package org.example.transaction;

public class Transaction {
    private TransactionType transactionType;
    private String accountNumber;
    private String accountOwnerName;
    private double transactionVolume;

    public Transaction(TransactionType transactionType, String accountNumber, String accountOwnerName, double transactionVolume){
        this.transactionType = transactionType;
        this.accountNumber = accountNumber;
        this.accountOwnerName = accountOwnerName;
        this.transactionVolume = transactionVolume;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountOwnerName() {
        return accountOwnerName;
    }

    public double getTransactionVolume() {
        return transactionVolume;
    }
}
