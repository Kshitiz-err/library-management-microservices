package com.microservices.issueservice.service;

import com.microservices.issueservice.entity.IssueRecord;

import java.util.List;

public interface IssueService {
    List<IssueRecord> getAll();
    IssueRecord getById(Long id);
    String updateRecord(Long id);
    IssueRecord addRecord(IssueRecord issueRecord);

}
