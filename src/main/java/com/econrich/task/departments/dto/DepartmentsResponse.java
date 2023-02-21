package com.econrich.task.departments.dto;

import com.econrich.task.departments.domain.Departments;
import com.econrich.task.locations.dto.LocationsResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class DepartmentsResponse {
    private Long departmentId;
    private String departmentName;
    private LocationsResponse locationsResponse;

    public static DepartmentsResponse of(Departments departments) {
        return DepartmentsResponse.builder()
                .departmentId(departments.getDepartmentId())
                .departmentName(departments.getDepartmentName())
                .locationsResponse(LocationsResponse.of(departments.getLocations()))
                .build();
    }
}
