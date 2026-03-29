package com.microservices.fineservice.repository;

import com.microservices.fineservice.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FineRepository extends JpaRepository<Fine,Long> {
}
