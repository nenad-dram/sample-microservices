package com.endyary.samplemicroservices.department.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Department {

    private Long id;
    private Long organizationId;
    private String name;
}
