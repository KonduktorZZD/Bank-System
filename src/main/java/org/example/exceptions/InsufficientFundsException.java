package org.example.exceptions;

//Klasa obsługuje wyjątek zbyt małej liczby funduszy na koncie
public class InsufficientFundsException extends Exception{
    public InsufficientFundsException(String message){
        super(message);
    }
}
