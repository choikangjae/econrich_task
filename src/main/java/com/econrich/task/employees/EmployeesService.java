package com.econrich.task.employees;

import com.econrich.task.departments.domain.DepartmentsRepository;
import com.econrich.task.employees.domain.Employees;
import com.econrich.task.employees.domain.EmployeesRepository;
import com.econrich.task.employees.dto.EmployeesResponse;
import com.econrich.task.employees.dto.UpdateEmployeeInfoRequest;
import com.econrich.task.employees.dto.UpdateSalaryRequest;
import com.econrich.task.exception.BaseException;
import com.econrich.task.exception.ErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeesService {

    private final EmployeesRepository employeesRepository;
    private final DepartmentsRepository departmentsRepository;

    @Transactional(readOnly = true)
    public EmployeesResponse findById(Long id) {
        Employees employee = employeesRepository.findByEmployeeId(id)
                .orElseThrow(() -> new BaseException(ErrorType.EMPLOYEE_NOT_FOUND));

        return EmployeesResponse.of(employee);
    }

    public Integer increaseEmployeeSalaryByPercentageInDepartmentId(UpdateSalaryRequest request) {
        if (!departmentsRepository.existsById(request.getDepartmentId()))
            throw new BaseException(ErrorType.DEPARTMENT_NOT_EXISTS);

        return employeesRepository.increaseSalary(request.getIncreaseRate(), request.getDepartmentId());
    }

    public void updateEmployeeInfo(Long id, UpdateEmployeeInfoRequest request) {
        Employees employee = employeesRepository.findByEmployeeId(id)
                .orElseThrow(() -> new BaseException(ErrorType.EMPLOYEE_NOT_FOUND));
        employee.updateEmployeeInfo(request);
    }
}
