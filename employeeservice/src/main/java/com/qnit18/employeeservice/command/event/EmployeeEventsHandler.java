package com.qnit18.employeeservice.command.event;

import com.qnit18.employeeservice.command.data.Employee;
import com.qnit18.employeeservice.command.repository.EmployeeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeEventsHandler {

    @Autowired
    private EmployeeRepository employeeRepository;

    @EventHandler
    public void on(EmployeeCreatedEvent event){
        Employee employee = new Employee();
        BeanUtils.copyProperties(event, employee);
        employeeRepository.save(employee);
    }

    @EventHandler
    public void on(EmployeeUpdatedEvent event){
        Optional<Employee> employee = employeeRepository.findById(event.getId());
        System.out.println("Employee: " + employee);
        employee.ifPresent(employee1 -> {
            employee1.setFirstName(event.getFirstName());
            employee1.setLastName(event.getLastName());
            employee1.setKin(event.getKin());
            employee1.setIsDisciplined(event.getIsDisciplined());
            System.out.println("Employee1: " + employee1);
            employeeRepository.save(employee1);
        });
    }
}
