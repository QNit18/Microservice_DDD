package com.qnit18.employeeservice.command.command;

import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeCommand {

    @TargetAggregateIdentifier
    private String id;
    private String firstName;
    private String lastName;
    private String Kin;
    private Boolean isDisciplined;
}
