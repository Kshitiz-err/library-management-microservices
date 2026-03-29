package com.microservices.fineservice.service.impl;

import com.microservices.fineservice.entity.Payment;
import com.microservices.fineservice.repository.PaymentRepository;
import com.microservices.fineservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> paymentList() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getById(Long id) {
        return paymentRepository.findById(id).orElseThrow(()->new RuntimeException("PAYMENT NOT FOUND"));
    }

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
