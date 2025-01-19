package com.desi.chicken.controller;

import com.desi.chicken.model.Payment;
import com.desi.chicken.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("payments")
    public Payment processPayment(@RequestBody Payment payment){
        return paymentService.processPayment(payment);
    }
}
