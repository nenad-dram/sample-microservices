package com.endyary.samplemicroservices.organization.department;

import com.endyary.samplemicroservices.organization.employee.Employee;
import lombok.Data;

import java.util.List;

@Data
public class Department {

    private Long id;
    private Long organizationId;
    private String name;
    private List<Employee> employees;
}
