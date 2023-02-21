package com.econrich.task.employees.domain;

import com.econrich.task.departments.domain.Departments;
import com.econrich.task.employees.dto.UpdateEmployeeInfoRequest;
import com.econrich.task.jobs.domain.Jobs;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Employees {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private Double salary;
    private Double commissionPct;

    public void updateEmployeeInfo(UpdateEmployeeInfoRequest request) {
        if (request.getFirstName() != null) this.firstName = request.getFirstName();
        if (request.getLastName() != null) this.lastName = request.getLastName();
        if (request.getEmail() != null) this.email = request.getEmail();
        if (request.getPhoneNumber() != null) this.phoneNumber = request.getPhoneNumber();
        if (request.getCommissionPct() != null) this.commissionPct = request.getCommissionPct();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Jobs job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Employees manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Departments department;

}
