package org.example.exceptions;

//Klasa obsługująca błąd przy transferze środków
public class TransferFundsException  extends  Exception{
    public TransferFundsException(String messagge){
        super(messagge);
    }
}
