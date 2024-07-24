package com.qnit18.employeeservice.query.projection;

import com.qnit18.employeeservice.command.data.Employee;
import com.qnit18.employeeservice.command.repository.EmployeeRepository;
import com.qnit18.employeeservice.query.model.EmployeeResponseModel;
import com.qnit18.employeeservice.query.queries.GetAllEmployeeQuery;
import com.qnit18.employeeservice.query.queries.GetEmployeeByIdQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeProjection {

    @Autowired
    private EmployeeRepository employeeRepository;

    @QueryHandler
    public List<EmployeeResponseModel> handle(GetAllEmployeeQuery query){
        List<Employee> employees = employeeRepository.findAllByIsDisciplined(query.getIsDisciplined());

        List<EmployeeResponseModel> employeeResponseModels = new ArrayList<>();

        employees.forEach(employee -> {
            EmployeeResponseModel employeeResponseModel = new EmployeeResponseModel();
            employeeResponseModel.setId(employee.getId());
            employeeResponseModel.setFirstName(employee.getFirstName());
            employeeResponseModel.setLastName(employee.getLastName());
            employeeResponseModel.setKin(employee.getKin());
            employeeResponseModel.setIsDisciplined(employee.getIsDisciplined());
            employeeResponseModels.add(employeeResponseModel);
        });

        return employeeResponseModels;
    }

    @QueryHandler
    public EmployeeResponseModel handle(GetEmployeeByIdQuery query) throws Exception {
        Employee fEmployee = employeeRepository.findById(query.getId()).orElseThrow(() -> new Exception("Not found employee by id" + query.getId()));

        EmployeeResponseModel employeeResponseModel = new EmployeeResponseModel();
        BeanUtils.copyProperties(fEmployee, employeeResponseModel);

        return employeeResponseModel;
    }
}
