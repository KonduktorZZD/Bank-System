package org.example;

import org.example.bankaccount.AccountList;
import org.example.bankaccount.AccountType;
import org.example.bankaccount.accounts.NormalAccount;
import org.example.bankaccount.accounts.SavingsAccount;
import org.example.exceptions.InsufficientFundsException;
import org.example.transaction.Transaction;
import org.example.transaction.TransactionHistory;
import org.example.transaction.TransactionType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InsufficientFundsException {
        Scanner scanner = new Scanner(System.in);
        AccountList accountsList = new AccountList();
        TransactionHistory transactionHistory = new TransactionHistory();

        String ownerName;
        double balance;

        //Tworzenie konta
        System.out.println("Tworzenie konta bankowego");

        System.out.println("Podaj imię właściciela: ");
        ownerName = scanner.nextLine();

        System.out.println("Podaj stan początkowy konta: ");
        balance = scanner.nextDouble();

        NormalAccount normalAccount = new NormalAccount(ownerName, balance, AccountType.NORMAL);
        accountsList.addAccountToList(normalAccount);

        SavingsAccount savingsAccount = new SavingsAccount("Hilary Clinton", 2000.20, AccountType.SAVINGS);
        accountsList.addAccountToList(savingsAccount);

        //wyświetlenie kont
        System.out.println("Istniejące konta: ");
        accountsList.showAllAccounts();

        //Wlata na konto  normalAccount
        normalAccount.deposit(400);

        //Stworzenie obiektu klasy Transaction
        Transaction transactionOne = new Transaction(TransactionType.DEPOSIT, normalAccount.getAccountNumber(),
                normalAccount.getAccountOwnerName(), 400);

        //Dodanie transackji do historii transakcji
        transactionHistory.addTransactionToList(transactionOne);

        //Pokazanie realizacji Wpłaty
        accountsList.showAllAccounts();


        //Wypłata z konta normalAccount
        normalAccount.withdraw(700);

        //Stworzenie obiektu klasy Transaction
        Transaction transactionTwo = new Transaction(TransactionType.WITHDRAW, normalAccount.getAccountNumber(),
                normalAccount.getAccountOwnerName(), 700);

        //Dodanie transackji do historii transakcji
        transactionHistory.addTransactionToList(transactionTwo);

        //pokazanie że wypłata nastapiła
        accountsList.showAllAccounts();

        //Wyświetlenie historii transakcji:
        transactionHistory.getDisplayTransactionsSpecificAccount(normalAccount.getAccountNumber());
    }
}
