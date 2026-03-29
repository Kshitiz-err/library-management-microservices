package com.microservice.inventoryservice.service;

import com.microservice.inventoryservice.InventoryServiceApplication;
import com.microservice.inventoryservice.entity.Inventory;

import java.util.List;

public interface InventoryService {
    List<Inventory> getAll();
    Inventory getById(Long id);
    Inventory addInventory(Inventory inventory);
}
