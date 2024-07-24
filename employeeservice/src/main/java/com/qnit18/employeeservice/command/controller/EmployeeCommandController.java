package com.qnit18.employeeservice.command.controller;

import com.qnit18.employeeservice.command.command.CreateEmployeeCommand;
import com.qnit18.employeeservice.command.command.DeleteEmployeeCommand;
import com.qnit18.employeeservice.command.command.UpdateEmployeeCommand;
import com.qnit18.employeeservice.command.model.CreateEmployeeModel;
import com.qnit18.employeeservice.command.model.UpdateEmployeeModel;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public String addEmployee(@RequestBody @Valid CreateEmployeeModel employeeRequestModel){
        CreateEmployeeCommand employeeCommand = new CreateEmployeeCommand(UUID.randomUUID().toString(),
                employeeRequestModel.getFirstName(),employeeRequestModel.getLastName(),
                employeeRequestModel.getKin(), false);
        return commandGateway.sendAndWait(employeeCommand);
    }

    @PutMapping("/{employeeId}")
    public String updateEmployee(@RequestBody @Valid UpdateEmployeeModel employeeModel, @PathVariable String employeeId){
        UpdateEmployeeCommand command = new UpdateEmployeeCommand(employeeId, employeeModel.getFirstName(),
                employeeModel.getLastName(), employeeModel.getKin(), employeeModel.getIsDisciplined());
        return commandGateway.sendAndWait(command);
    }

//    @Hidden
    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId){
        DeleteEmployeeCommand command = new DeleteEmployeeCommand(employeeId);
        return commandGateway.sendAndWait(command);
    }
}
