package org.example.aop;

import org.springframework.stereotype.Component;

@Component("TransactionBean")
public class Transaction {
    public void startTransaction(){
        System.out.println("start transaction");
    }
    public void endTransaction(){
        System.out.println("end transaction");
    }
}
