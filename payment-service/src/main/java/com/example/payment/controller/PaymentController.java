package com.example.payment.controller;

import com.example.payment.entity.Payment;
import com.example.payment.response.PaymentWithCustomer;
import com.example.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/")
    public Payment savePayment(@RequestBody Payment payment) {
        log.info("Save payment request received");
        return paymentService.savePayment(payment);
    }

    @GetMapping("/{id}")
    public PaymentWithCustomer findPaymentById(@PathVariable("id") Long paymentId) {
        log.info("Find payment by id request received: " + paymentId);
        return paymentService.getPaymentWithCustomer(paymentId);
    }
}
