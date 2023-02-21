package com.econrich.task.employees.dto;

import com.econrich.task.employees.domain.Employees;
import com.econrich.task.jobs.dto.JobsResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Builder
public class EmployeesResponse {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String hireDate;

    private JobsResponse jobs;
    private Double salary;
    private Double commissionPct;

    @Setter
    private EmployeesResponse manager;

    public static EmployeesResponse of(Employees employees) {
        EmployeesResponse managerResponse = getResponse(employees.getManager());

        EmployeesResponse response = getResponse(employees);
        response.setManager(managerResponse);

        return response;
    }
    private static EmployeesResponse getResponse(Employees employees) {
        return EmployeesResponse.builder()
                .employeeId(employees.getEmployeeId())
                .firstName(employees.getFirstName())
                .lastName(employees.getLastName())
                .email(employees.getEmail())
                .phoneNumber(employees.getPhoneNumber())
                .hireDate(employees.getHireDate().toString())
                .jobs(JobsResponse.of(employees.getJob()))
                .salary(employees.getSalary())
                .commissionPct(employees.getCommissionPct())
                .build();
    }
}
