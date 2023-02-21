package com.econrich.task.jobhistory.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {
    @Query("select j from JobHistory j " +
            "join fetch j.departments d join fetch d.locations l join fetch l.countries c join fetch c.regions join fetch d.manager " +
            "join fetch j.employees e join fetch e.manager m join fetch m.job  join fetch m.department join fetch e.department join fetch e.job " +
            "join fetch j.jobs where j.id.employeeId = ?1")
    List<JobHistory> findAllByIdEmployeeId(Long employeeId);
}
