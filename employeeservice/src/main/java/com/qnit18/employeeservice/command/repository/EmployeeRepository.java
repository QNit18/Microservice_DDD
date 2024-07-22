package com.qnit18.employeeservice.command.repository;

import com.qnit18.employeeservice.command.data.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
