package com.microservices.fineservice.service;

import com.microservices.fineservice.entity.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> paymentList();
    Payment getById(Long id);
    Payment addPayment(Payment payment);
}
