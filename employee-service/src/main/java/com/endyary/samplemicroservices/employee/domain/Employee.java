package com.endyary.samplemicroservices.employee.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {

    private Long id;
    private Long organizationId;
    private Long departmentId;
    private String name;
    private int age;
    private String position;
}
