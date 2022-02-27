package com.endyary.samplemicroservices.organization.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Organization {

    private Long id;
    private String name;
    private String address;
}
