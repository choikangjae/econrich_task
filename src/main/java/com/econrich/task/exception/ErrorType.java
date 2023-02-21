package com.econrich.task.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorType {

    // Employee
    EMPLOYEE_NOT_FOUND("EMP001", "사원 정보가 존재하지 않습니다", HttpStatus.NOT_FOUND),

    // Department
    DEPARTMENT_NOT_EXISTS("DEPT001", "부서 정보가 존재하지 않습니다", HttpStatus.NOT_FOUND),

    // JobHistory
    JOBHISTORY_NOT_FOUND("JOB001", "사원 이력 정보가 존재하지 않습니다", HttpStatus.NOT_FOUND),

    // Location
    LOCATION_NOT_FOUND("LOC001", "위치 정보가 존재하지 않습니다", HttpStatus.NOT_FOUND),

    // Open API
    OPENAPI_ERROR("OPENAPI001", "Open API에서 에러가 발생하였습니다", HttpStatus.NOT_FOUND),

    // Parameter
    PARAM_VALID_ERROR("PARAM001", "Parameter is invalid", HttpStatus.BAD_REQUEST),

    // Method
    METHOD_NOT_ALLOWED("METHOD001", "Method is not allowed", HttpStatus.METHOD_NOT_ALLOWED),
    ;

    private final String code;
    private final String message;
    private final HttpStatus status;

}
