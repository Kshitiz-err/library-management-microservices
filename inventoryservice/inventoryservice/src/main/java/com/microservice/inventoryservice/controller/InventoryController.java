package com.microservice.inventoryservice.controller;

import com.microservice.inventoryservice.entity.Inventory;
import com.microservice.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @GetMapping
    public List<Inventory> get(){
        return inventoryService.getAll();
    }
    @GetMapping("/{id}")
    public Inventory getInventoryById(@PathVariable Long id){
        return inventoryService.getById(id);
    }
    @PostMapping
    public Inventory add(@RequestBody Inventory inventory){
        return inventoryService.addInventory(inventory);
    }
}
