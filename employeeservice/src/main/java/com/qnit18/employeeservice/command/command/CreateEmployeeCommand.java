package com.qnit18.employeeservice.command.command;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateEmployeeCommand {

    @TargetAggregateIdentifier
    String id;
    String firstName;
    String lastName;
    String Kin;
    Boolean isDisciplined;
}
