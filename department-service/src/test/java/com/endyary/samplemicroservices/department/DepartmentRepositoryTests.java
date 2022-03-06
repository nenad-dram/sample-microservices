package com.endyary.samplemicroservices.department;

import com.endyary.samplemicroservices.department.domain.Department;
import com.endyary.samplemicroservices.department.domain.DepartmentRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DepartmentRepositoryTests {

    @InjectMocks
    private DepartmentRepository departmentRepository;

    @Test
    public void add_validObject_objectAdded() {
        Department expectedDepartment = Department.builder().name("Test Dep").organizationId(1L).build();
        departmentRepository.add(expectedDepartment);
        Assertions.assertThat(expectedDepartment.getId()).isNotNull();
    }

    @Test
    public void findAll_listNotEmpty() {
        List<Department> actualList = departmentRepository.findAll();
        Assertions.assertThat(actualList).hasSizeGreaterThan(0);
    }

    @Test
    public void findById_validId_returnObject() {
        Department actualDepartment = departmentRepository.findById(1L);
        Assertions.assertThat(actualDepartment.getId()).isNotNull();
    }

    @Test
    public void findByOrganization_validId_returnObject() {
        Long expectedOrgId = 1L;
        List<Department> actualList = departmentRepository.findByOrganization(expectedOrgId);

        SoftAssertions departmentAssert = new SoftAssertions();
        departmentAssert.assertThat(actualList).hasSizeGreaterThan(0);
        departmentAssert.assertThat(actualList.get(0).getOrganizationId()).isEqualTo(expectedOrgId);
        departmentAssert.assertAll();
    }
}
