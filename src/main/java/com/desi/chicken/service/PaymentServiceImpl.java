package com.desi.chicken.service;

import com.desi.chicken.kafka.message.service.PaymentMessageService;
import com.desi.chicken.model.Payment;
import com.desi.chicken.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentMessageService paymentMessageService;

    @Override
    public Payment processPayment(Payment payment){
       //payment.setStatus("Completed");
        Payment savePayment = paymentRepository.save(payment);
        paymentMessageService.sendPaymentEvent(payment);
        return payment;
    }
}
