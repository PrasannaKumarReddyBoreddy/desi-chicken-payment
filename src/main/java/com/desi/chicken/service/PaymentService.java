package com.desi.chicken.service;

import com.desi.chicken.model.Payment;
import org.springframework.stereotype.Service;


public interface PaymentService {
    public Payment processPayment(Payment payment);
}
