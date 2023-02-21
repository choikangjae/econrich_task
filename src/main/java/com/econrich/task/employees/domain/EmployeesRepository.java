package com.econrich.task.employees.domain;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {

    Boolean existsByDepartmentDepartmentId(Long departmentId);

    @EntityGraph(attributePaths = {"job", "manager", "department", "manager.job"})
    Optional<Employees> findByEmployeeId(Long id);

    @Query("update Employees e set e.salary = e.salary + e.salary * :increaseRate where e.department.departmentId = :departmentId")
    @Modifying
    Integer increaseSalary(@Param("increaseRate") Double increaseRate, @Param("departmentId") Long departmentId);
}
