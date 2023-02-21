package com.econrich.task.employees.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateEmployeeInfoRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Double commissionPct;
}
