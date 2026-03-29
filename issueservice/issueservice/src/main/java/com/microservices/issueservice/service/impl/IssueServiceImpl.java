package com.microservices.issueservice.service.impl;

import com.microservices.issueservice.entity.IssueRecord;
import com.microservices.issueservice.entity.Status;
import com.microservices.issueservice.repository.IssueRecordRepository;
import com.microservices.issueservice.service.BookClient;
import com.microservices.issueservice.service.IssueService;
import com.microservices.issueservice.service.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssueServiceImpl implements IssueService {
    @Autowired
    private IssueRecordRepository issueRecordRepository;
    @Autowired
    private UserClient userClient;
    @Autowired
    private BookClient bookClient;
    @Override
    public List<IssueRecord> getAll() {
        return issueRecordRepository.findAll().stream().map(issueRecord -> {
            issueRecord.setUserProfile(userClient.getById(issueRecord.getId()));
            issueRecord.setBook(bookClient.getById(issueRecord.getBookId()));
            return issueRecord;
        }).collect(Collectors.toList());

    }

    @Override
    public IssueRecord getById(Long id) {
        IssueRecord found = issueRecordRepository.findById(id).orElseThrow(() -> new RuntimeException("Record not found"));
        found.setUserProfile(userClient.getById(found.getUserId()));
        found.setBook(bookClient.getById(found.getBookId()));
        return found;
    }

    @Override
    public String updateRecord(Long id) {
        IssueRecord found = issueRecordRepository.findById(id).orElseThrow(() -> new RuntimeException("Issue Not found"));
        if(found!=null){
            int i = issueRecordRepository.updateRecordById(id, LocalDate.now(), Status.RETURNED.toString());
            if(i>0)return i+" Records updated";else return "0";
        }
        return "Wrong ID";
    }

    @Override
    public IssueRecord addRecord(IssueRecord issueRecord) {
        issueRecord.setCreatedAt(LocalDateTime.now());
        issueRecord.setDueDate(LocalDate.now().plusDays(7));
        issueRecord.setReturnDate(null);
        return issueRecordRepository.save(issueRecord);
    }
}
