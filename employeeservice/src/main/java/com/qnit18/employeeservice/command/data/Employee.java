package com.qnit18.employeeservice.command.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "employees")
@Builder
public class Employee {
    @Id
    String id;
    String firstName;
    String lastName;
    String Kin;
    Boolean isDisciplined;
}
