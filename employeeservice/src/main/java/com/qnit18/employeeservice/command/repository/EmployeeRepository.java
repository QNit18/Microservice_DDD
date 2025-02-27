package com.qnit18.employeeservice.command.repository;

import com.qnit18.employeeservice.command.data.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    List<Employee> findAllByIsDisciplined(Boolean isDisciplined);
}
