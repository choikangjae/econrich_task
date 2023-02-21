package com.econrich.task.departments;

import com.econrich.task.departments.domain.Departments;
import com.econrich.task.departments.domain.DepartmentsRepository;
import com.econrich.task.departments.dto.DepartmentsResponse;
import com.econrich.task.exception.BaseException;
import com.econrich.task.exception.ErrorType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentsService {
    private final DepartmentsRepository departmentsRepository;

    public DepartmentsResponse getDepartmentsById(Long id) {
        Departments departments = departmentsRepository.findByDepartmentId(id)
                .orElseThrow(() -> new BaseException(ErrorType.DEPARTMENT_NOT_EXISTS));
        return DepartmentsResponse.of(departments);
    }
}
