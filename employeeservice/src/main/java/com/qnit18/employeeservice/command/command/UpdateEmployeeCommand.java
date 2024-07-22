package com.qnit18.employeeservice.command.command;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateEmployeeCommand {

    @TargetAggregateIdentifier
    String id;
    String firstName;
    String lastName;
    String Kin;
    Boolean isDisciplined;
}
