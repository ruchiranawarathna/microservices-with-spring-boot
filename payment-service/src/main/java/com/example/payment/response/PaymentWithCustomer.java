package com.example.payment.response;

import com.example.payment.entity.Payment;
import lombok.Data;

@Data
public class PaymentWithCustomer {
    private Payment payment;
    private Customer customer;
}
