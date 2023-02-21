package com.econrich.task.jobhistory.domain;

import com.econrich.task.departments.domain.Departments;
import com.econrich.task.employees.domain.Employees;
import com.econrich.task.jobs.domain.Jobs;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "job_history", schema = "hr")
public class JobHistory {
    @EmbeddedId
    private JobHistoryId id;
    private Date startDate;
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    @MapsId("employeeId")
    @EqualsAndHashCode.Include
    private Employees employees;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    @MapsId("jobId")
    @EqualsAndHashCode.Include
    private Jobs jobs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @MapsId("departmentId")
    @EqualsAndHashCode.Include
    private Departments departments;

    public JobHistory(Employees employees, Jobs jobs, Departments departments) {
        this.employees = employees;
        this.jobs = jobs;
        this.departments = departments;
        this.id = new JobHistoryId(employees.getEmployeeId(), jobs.getJobId(), departments.getDepartmentId());
    }
}
