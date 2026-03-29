package com.microservices.fineservice.controller;

import com.microservices.fineservice.entity.Payment;
import com.microservices.fineservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fine/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id){
        return paymentService.getById(id);
    }
    @GetMapping
    public List<Payment> getAll(){
        return paymentService.paymentList();
    }
    @PostMapping
    public Payment addPayment(@RequestBody Payment payment){
        return paymentService.addPayment(payment);
    }
}
