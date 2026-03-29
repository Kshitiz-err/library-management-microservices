package com.microservices.issueservice.controller;

import com.microservices.issueservice.entity.IssueRecord;
import com.microservices.issueservice.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issue")
public class IssueController {
    @Autowired
    private IssueService issueService;

    @GetMapping
    public List<IssueRecord> get(){
        return issueService.getAll();
    }
    @GetMapping("/{id}")
    public IssueRecord getById(@PathVariable Long id){
        return issueService.getById(id);
    }
    @PutMapping("/update")
    public String updateRecord(@RequestParam Long id){
        return issueService.updateRecord(id);
    }
    @PostMapping
    public IssueRecord issueRecord(@RequestBody IssueRecord issueRecord){
        return issueService.addRecord(issueRecord);
    }
}
