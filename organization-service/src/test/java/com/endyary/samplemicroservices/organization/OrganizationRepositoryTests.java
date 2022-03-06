package com.endyary.samplemicroservices.organization;

import com.endyary.samplemicroservices.organization.domain.Organization;
import com.endyary.samplemicroservices.organization.domain.OrganizationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class OrganizationRepositoryTests {

    @InjectMocks
    private OrganizationRepository organizationRepository;

    @Test
    public void add_validObject_objectAdded() {
        Organization expectedOrganization = Organization.builder().name("Test Org").address("Test Address").build();
        organizationRepository.add(expectedOrganization);
        Assertions.assertThat(expectedOrganization.getId()).isNotNull();
    }

    @Test
    public void findAll_listNotEmpty() {
        List<Organization> actualList = organizationRepository.findAll();
        Assertions.assertThat(actualList).hasSizeGreaterThan(0);
    }

    @Test
    public void findById_validId_returnObject() {
        Organization actualOrganization = organizationRepository.findById(1L);
        Assertions.assertThat(actualOrganization.getId()).isNotNull();
    }
}
