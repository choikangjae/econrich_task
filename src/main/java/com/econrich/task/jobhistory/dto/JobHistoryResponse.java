package com.econrich.task.jobhistory.dto;

import com.econrich.task.departments.dto.DepartmentsResponse;
import com.econrich.task.employees.dto.EmployeesResponse;
import com.econrich.task.jobhistory.domain.JobHistory;
import com.econrich.task.jobs.dto.JobsResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class JobHistoryResponse {

    private EmployeesResponse employeesResponse;
    private JobsResponse jobsResponse;
    private DepartmentsResponse departmentsResponse;
    private Date startDate;
    private Date endDate;

    public static JobHistoryResponse of(JobHistory jobHistory) {
        return JobHistoryResponse.builder()
                .employeesResponse(EmployeesResponse.of(jobHistory.getEmployees()))
                .jobsResponse(JobsResponse.of(jobHistory.getJobs()))
                .departmentsResponse(DepartmentsResponse.of(jobHistory.getDepartments()))
                .startDate(jobHistory.getStartDate())
                .endDate(jobHistory.getEndDate())
                .build();
    }
}
