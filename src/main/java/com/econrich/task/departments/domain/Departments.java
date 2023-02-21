package com.econrich.task.departments.domain;

import com.econrich.task.employees.domain.Employees;
import com.econrich.task.locations.domain.Locations;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Departments {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long departmentId;
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Employees manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Locations locations;
}
