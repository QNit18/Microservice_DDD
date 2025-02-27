package com.qnit18.employeeservice.command.event;

import com.qnit18.employeeservice.command.data.Employee;
import com.qnit18.employeeservice.command.repository.EmployeeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeEventsHandler {

    private static final Logger log = LoggerFactory.getLogger(EmployeeEventsHandler.class);
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
        try{
            Optional<Employee> employee = Optional.ofNullable(employeeRepository.findById(event.getId()).orElseThrow(() -> new Exception("Not found employee with id")));
            System.out.println("Employee: " + employee);
            employee.ifPresent(employee1 -> {
                employee1.setFirstName(event.getFirstName());
                employee1.setLastName(event.getLastName());
                employee1.setKin(event.getKin());
                employee1.setIsDisciplined(event.getIsDisciplined());
                System.out.println("Employee1: " + employee1);
                employeeRepository.save(employee1);
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @EventHandler
    public void on(EmployeeDeletedEvent event){
        employeeRepository.deleteById(event.getId());
        try {
            employeeRepository.findById(event.getId()).orElseThrow(() -> new Exception("Not found employee with id"));
            employeeRepository.deleteById(event.getId());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
