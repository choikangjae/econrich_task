package com.econrich.task.departments.domain;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentsRepository extends JpaRepository<Departments, Long> {
    @EntityGraph(attributePaths = {"manager", "locations", "locations.countries", "locations.countries.regions"})
    Optional<Departments> findByDepartmentId(Long departmentId);
}
