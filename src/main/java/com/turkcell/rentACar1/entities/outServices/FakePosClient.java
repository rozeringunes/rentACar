package com.turkcell.rentACar1.entities.outServices;

import java.util.Random;

public class FakePosClient {
    public boolean createPayment(String cardNumber,String cardHolderName,String cvv,String expireDate,double amount){
        Random random =new Random();
        return random.nextBoolean();
    }
}
