package com.example.customer.service;

import com.example.customer.entity.Customer;
import com.example.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        log.info("Save customer");
        return customerRepository.save(customer);
    }

    public Customer findById(Long customerId) {
        log.info("Find customer");
        return customerRepository.findByCustomerId(customerId).get();
    }
}
