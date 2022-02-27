package com.endyary.samplemicroservices.organization.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OrganizationRepository {
    private static final List<Organization> organizations = new ArrayList<>();

    static {
        Organization.OrganizationBuilder orgBld = new Organization.OrganizationBuilder();
        organizations.add(orgBld.id(1L).name("Google").address("Mountain View, California, USA").build());
        organizations.add(orgBld.id(2L).name("Oracle").address("Redwood City, California, USA").build());
    }

    public Organization add(Organization organization) {
        organization.setId((long) (organizations.size()+1));
        organizations.add(organization);
        return organization;
    }

    public Organization findById(Long id) {
        Optional<Organization> organization = organizations.stream().filter(a -> a.getId().equals(id)).findFirst();
        return organization.orElse(null);
    }

    public List<Organization> findAll() {
        return organizations;
    }
}

