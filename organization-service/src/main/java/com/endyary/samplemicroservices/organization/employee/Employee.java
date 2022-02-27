package com.endyary.samplemicroservices.organization.employee;

import lombok.Data;

@Data
public class Employee {

    private Long id;
    private Long organizationId;
    private Long departmentId;
    private String name;
    private int age;
    private String position;
}
