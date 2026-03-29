package com.microservices.fineservice.service;

import com.microservices.fineservice.entity.Fine;

import java.util.List;

public interface FineService {
    List<Fine> getAll();
    Fine getByFineId(Long id);
    Fine addFine(Fine fine);
}
