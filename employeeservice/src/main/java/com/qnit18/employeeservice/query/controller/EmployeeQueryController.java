package com.qnit18.employeeservice.query.controller;

import com.qnit18.employeeservice.query.model.EmployeeResponseModel;
import com.qnit18.employeeservice.query.queries.GetAllEmployeeQuery;
import com.qnit18.employeeservice.query.queries.GetEmployeeByIdQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public List<EmployeeResponseModel> getAllEmployees(){
        GetAllEmployeeQuery query = new GetAllEmployeeQuery();
        return queryGateway.query(query, ResponseTypes.multipleInstancesOf(EmployeeResponseModel.class)).join();
    }

    @GetMapping("/{employeeId}")
    public EmployeeResponseModel getEmployeeById(@PathVariable String employeeId){
        GetEmployeeByIdQuery query = new GetEmployeeByIdQuery(employeeId);
        return queryGateway.query(query, ResponseTypes.instanceOf(EmployeeResponseModel.class)).join();
    }
}
