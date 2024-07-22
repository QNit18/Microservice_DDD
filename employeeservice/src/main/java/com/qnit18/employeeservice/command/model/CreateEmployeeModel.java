package com.qnit18.employeeservice.command.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRequestModel {

    @Size(min = 2, max = 30, message = "First name can be only from 2 to 30 characters")
    @NotBlank(message = "You must enter your first name")
    String firstName;

    @Size(min = 4, max = 30, message = "Last name can be only from 4 to 30 characters")
    @NotBlank(message = "You must enter your last name")
    String lastName;

    String Kin;

}
