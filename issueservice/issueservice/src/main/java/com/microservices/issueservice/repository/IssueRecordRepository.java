package com.microservices.issueservice.repository;

import com.microservices.issueservice.entity.IssueRecord;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IssueRecordRepository extends JpaRepository<IssueRecord,Long> {
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE issue_db.issue_record " +
                    "SET return_date = :returnDate, status = :status " +
                    "WHERE id = :id",
            nativeQuery = true
    )
    int updateRecordById(
            @Param("id") Long id,
            @Param("returnDate") LocalDate returnDate,
            @Param("status") String status
    );
}
