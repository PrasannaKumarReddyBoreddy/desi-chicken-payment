package com.desi.chicken.kafka.message.service;

import com.desi.chicken.model.Payment;
import com.desi.chicken.utils.KakfaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentMessageService {

    @Autowired
    private KafkaTemplate<String, Payment> kafkaTemplate;

    public void sendPaymentEvent(Payment payment){
        kafkaTemplate.send(KakfaConstants.TOPIC, payment);
    }
}
