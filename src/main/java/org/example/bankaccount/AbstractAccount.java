package org.example.bankaccount;

import org.example.bankaccount.AccountList;

import org.example.exceptions.InsufficientFundsException;
import org.example.exceptions.TransferFundsException;
import org.example.transaction.Transaction;
import org.example.transaction.TransactionType;

import java.util.Random;

public abstract class AbstractAccount extends AccountList implements BankAccount {
    //Atrybuty klasy AbstractAccount
    protected String accountNumber;
    protected String accountOwnerName;
    protected double accountBalance;

    //konstruktor
   protected AbstractAccount(String accountOwnerName, double startBalance) {
        this.accountOwnerName = accountOwnerName;
        this.accountBalance = startBalance;
        this.accountNumber = generateAccountNumber();
    }

    //Gettery

    @Override
    public String getAccountOwnerName() {
        return accountOwnerName;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getAccountBalance() {
        return accountBalance;
    }


    //Metody do wpłaty, wypłaty i transferu

    //Wpłata na konto
    @Override
    public void deposit(double amountMoney) throws InsufficientFundsException {
        if( amountMoney > 0){
            //Utworzenie obiektu transaction,typ DEPOSIT
            Transaction transaction = new Transaction(TransactionType.DEPOSIT, accountNumber, accountOwnerName, amountMoney);
            accountBalance += amountMoney;
            System.out.println("Wpłata środków zakończona pomyślnie!");
        } else {
            throw new InsufficientFundsException("NIe możesz wpłacić na konto mniej niż 0");
        }

    }

    //Wypłata z konta
    @Override
    public void withdraw(double amountMoney) throws InsufficientFundsException{
        if (accountBalance >= amountMoney){
            //Utworzenie obiektu transaction,typ WITHDRAW
            Transaction transaction = new Transaction(TransactionType.WITHDRAW, accountNumber, accountOwnerName, amountMoney);
            accountBalance-=amountMoney;
            System.out.println("Wypłata środków zakończona pomyślnie");
        } else{
            throw new InsufficientFundsException("Masz za mało środków na koncie!!!\n Masz: " + accountBalance + ", a chcesz wypłacić: " + amountMoney);
        }

    }

    //Wpłata na inne konto
    @Override
    public void transfer(String destinationAccountNumber, double amountMoney) throws TransferFundsException {
        if(accountBalance < amountMoney){
            throw  new TransferFundsException("Masz za mało środków na koncie!!!\\n Masz: " + accountBalance +", a chcesz przelać: "  + amountMoney);
        } else if (!accountNumberIsExist(destinationAccountNumber)) {
            throw  new TransferFundsException("Podane konto nie istnieje!!!");
        } else{
            //Utworzenie obiektu transaction,typ TRANSFER
            Transaction transaction = new Transaction(TransactionType.TRANSFER, accountNumber, accountOwnerName, amountMoney);
            this.accountBalance -= amountMoney;

            for(AbstractAccount account : accountsNumberList){
                if(account.getAccountNumber() == destinationAccountNumber){
                    accountBalance +=amountMoney;
                    System.out.println("Transfer zakończony pomyślnie.");
                }
            }

        }
    }

    //Metody do generowania numerów konta:


    @Override
    public  String generateAccountNumber() {
        StringBuilder accountNumberBuilder = new StringBuilder();

        // Dodanie dwóch pierwszych cyfr (kod kraju)
        accountNumberBuilder.append("PL");


        //Petla która wykonuje się do momentu powstania numeru konta, którego wcześniej nie było
        while(accountNumberIsExist(accountNumberBuilder.toString())){
            // Generowanie 24 losowych cyfr
            Random random = new Random();
            for (int i = 0; i < 24; i++) {
                int digit = random.nextInt(10);
                accountNumberBuilder.append(digit);
            }
        }

        // Dodanie ostatniej cyfry (cyfra kontrolna)
        accountNumberBuilder.append(computeChecksum(accountNumberBuilder.toString()));

        return accountNumberBuilder.toString();
    }

    @Override
    public int computeChecksum(String accountNumber) {
        int[] weights = { 1, 10, 3, 30, 9, 90, 27, 76, 81, 34, 49, 5, 50, 15, 53, 45, 62, 38, 89, 17, 73, 51, 25, 56, 75 };
        int sum = 0;

        for (int i = 0; i < accountNumber.length(); i++) {
            int digit = Character.getNumericValue(accountNumber.charAt(i));
            sum += digit * weights[i];
        }

        int checksum = 98 - (sum % 97);
        return checksum;
    }
}
