package com.endyary.samplemicroservices.organization.domain;

import com.endyary.samplemicroservices.organization.department.Department;
import com.endyary.samplemicroservices.organization.employee.Employee;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder=true)
public class Organization {

    private Long id;
    private String name;
    private String address;
    private List<Employee> employees;
    private List<Department> departments;
}
