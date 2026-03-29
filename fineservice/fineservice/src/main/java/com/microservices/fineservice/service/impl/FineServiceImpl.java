package com.microservices.fineservice.service.impl;

import com.microservices.fineservice.entity.Fine;
import com.microservices.fineservice.repository.FineRepository;
import com.microservices.fineservice.repository.PaymentRepository;
import com.microservices.fineservice.service.FineService;
import com.microservices.fineservice.service.IssueClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FineServiceImpl implements FineService {
    @Autowired
    private IssueClient issueClient;
    @Autowired
    private FineRepository fineRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public List<Fine> getAll() {
        return fineRepository.findAll().stream().map(fine -> {
            fine.setIssueRecord(issueClient.getById(fine.getIssueId()));
            return fine;
        }).collect(Collectors.toList());
    }

    @Override
    public Fine getByFineId(Long id) {
        Fine fine = fineRepository.findById(id).orElseThrow(() -> new RuntimeException("Fine not found"));
        fine.setIssueRecord(issueClient.getById(fine.getIssueId()));
        return fine;
    }

    @Override
    public Fine addFine(Fine fine) {
        fine.setCreatedAt(LocalDateTime.now());
        return fineRepository.save(fine);
    }
}
