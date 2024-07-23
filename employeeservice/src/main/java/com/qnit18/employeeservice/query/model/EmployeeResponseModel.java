package com.qnit18.employeeservice.query.model;

import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeResponseModel {

    String id;
    String firstName;
    String lastName;
    String Kin;
    Boolean isDisciplined;
}
