package org.example.transaction;

import org.example.transaction.Transaction;

import java.util.ArrayList;

public class TransactionHistory {
    private ArrayList<Transaction> transactions;

    public TransactionHistory() {
        transactions = new ArrayList<>();
    }

    public void addTransactionToList(Transaction transaction) {
        transactions.add(transaction);
    }

    public void getAllTransaction() {
        int counter = 1;
        for (Transaction transaction : transactions) {
            System.out.println(counter + ". Rodzaj transakcji: " + transaction.getTransactionType() + ", Numer konta: " + transaction.getAccountNumber()
                    + ", Właściciel konta: " + transaction.getAccountOwnerName() + ", Wysokość przelewu: " + transaction.getTransactionVolume());
            counter++;
        }
    }

    public void getDisplayTransactionsSpecificAccount(String accountNumber) {
        int counter = 1;
        for (Transaction transaction : transactions) {
            if (transaction.getAccountNumber() == accountNumber) {
                System.out.println(counter + ". Rodzaj transakcji: " + transaction.getTransactionType() + " , Wysokość przelewu: " + transaction.getTransactionVolume());
                counter++;
            } else {
                System.out.println("Podane konto: " + accountNumber + " nie ma transakcji!");
            }
        }
    }
}
