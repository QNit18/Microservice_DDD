package com.qnit18.employeeservice.command.event;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeCreatedEvent {
    String id;
    String firstName;
    String lastName;
    String Kin;
    Boolean isDisciplined;
}
