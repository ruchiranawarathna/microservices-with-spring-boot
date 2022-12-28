package com.example.payment.service;

import com.example.payment.entity.Payment;
import com.example.payment.repository.PaymentRepository;
import com.example.payment.response.Customer;
import com.example.payment.response.PaymentWithCustomer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Payment savePayment(Payment payment) {
        log.info("Save payment");
        return paymentRepository.save(payment);
    }

    public Payment findById(Long paymentId) {
        log.info("Find payment");
        return paymentRepository.findByPaymentId(paymentId).get();
    }

    public PaymentWithCustomer getPaymentWithCustomer(Long paymentId) {
        log.info("Find payment with customer");
        PaymentWithCustomer paymentWithCustomer = new PaymentWithCustomer();
        Payment payment = paymentRepository.findByPaymentId(paymentId).get();

        Customer customer = restTemplate.getForObject("http://CUSTOMER-SERVICE/customers/" + payment.getCustomerId(), Customer.class);
        paymentWithCustomer.setCustomer(customer);
        paymentWithCustomer.setPayment(payment);
        return paymentWithCustomer;
    }
}
