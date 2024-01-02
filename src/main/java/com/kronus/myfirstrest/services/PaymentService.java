package com.kronus.myfirstrest.services;

import com.kronus.myfirstrest.exception.NotMoneyEnoughException;
import com.kronus.myfirstrest.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment() {
        throw new NotMoneyEnoughException();
    }
}
