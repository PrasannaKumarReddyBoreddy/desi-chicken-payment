package com.desi.chicken.controller;

import com.desi.chicken.model.Payment;
import com.desi.chicken.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("reddy")
    public void test(){
        System.out.println("testing the service");
    }

    @PostMapping("payments")
    public Payment processPayment(@RequestBody Payment payment){
        return paymentService.processPayment(payment);
    }
}
