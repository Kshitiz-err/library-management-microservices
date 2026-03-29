package com.microservice.inventoryservice.repository;

import com.microservice.inventoryservice.InventoryServiceApplication;
import com.microservice.inventoryservice.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
