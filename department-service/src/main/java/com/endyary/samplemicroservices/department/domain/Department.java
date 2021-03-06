package com.endyary.samplemicroservices.department.domain;

import com.endyary.samplemicroservices.department.employee.Employee;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class Department {

    private Long id;
    private Long organizationId;
    private String name;
    private List<Employee> employees;
}
