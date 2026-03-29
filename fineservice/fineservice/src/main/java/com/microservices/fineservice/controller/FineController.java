package com.microservices.fineservice.controller;

import com.microservices.fineservice.entity.Fine;
import com.microservices.fineservice.entity.Payment;
import com.microservices.fineservice.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fine")
public class FineController {
    @Autowired
    private FineService fineService;
    @GetMapping
    public List<Fine> getAll(){
        return fineService.getAll();
    }
    @GetMapping("/{id}")
    public Fine getById(@PathVariable Long id){
        return fineService.getByFineId(id);
    }
    @PostMapping
    public Fine addFine(@RequestBody Fine fine){
        return fineService.addFine(fine);
    }
}
