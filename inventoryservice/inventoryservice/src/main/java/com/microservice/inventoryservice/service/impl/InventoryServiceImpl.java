package com.microservice.inventoryservice.service.impl;

import com.microservice.inventoryservice.entity.Inventory;
import com.microservice.inventoryservice.repository.InventoryRepository;
import com.microservice.inventoryservice.service.BookClient;
import com.microservice.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private BookClient bookClient;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Override
    public List<Inventory> getAll() {
        List<Inventory> all = inventoryRepository.findAll();
        List<Inventory> collect = all.stream().map((inventory) -> {
            inventory.setBook(bookClient.getById(inventory.getBookId()));
            return inventory;
        }).collect(Collectors.toList());
        return collect;
    }

    @Override
    public Inventory getById(Long id) {
        Inventory byId = inventoryRepository.findById(id).orElseThrow(()->new RuntimeException("NOT FOUND"));
        byId.setBook(bookClient.getById(byId.getBookId()));
        return byId;
    }

    @Override
    public Inventory addInventory(Inventory inventory) {
        Inventory save = inventoryRepository.save(inventory);
        save.setBook(bookClient.getById(save.getBookId()));
        return save;
    }
}
