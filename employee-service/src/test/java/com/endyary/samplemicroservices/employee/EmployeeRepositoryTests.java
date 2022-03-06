package com.endyary.samplemicroservices.employee;

import com.endyary.samplemicroservices.employee.domain.Employee;
import com.endyary.samplemicroservices.employee.domain.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EmployeeRepositoryTests {

    @InjectMocks
    private EmployeeRepository employeeRepository;

    @Test
    public void add_validObject_objectAdded() {
        Employee expectedEmployee = Employee.builder().name("Test Emp").departmentId(1L).organizationId(2L).build();
        employeeRepository.add(expectedEmployee);
        Assertions.assertThat(expectedEmployee.getId()).isNotNull();
    }

    @Test
    public void findAll_listNotEmpty() {
        List<Employee> actualList = employeeRepository.findAll();
        Assertions.assertThat(actualList).hasSizeGreaterThan(0);
    }

    @Test
    public void findById_validId_returnObject() {
        Employee actualEmployee = employeeRepository.findById(1L);
        Assertions.assertThat(actualEmployee.getId()).isNotNull();
    }

    @Test
    public void findByDepartment_validId_returnObject() {
        Long expectedDepId = 1L;
        List<Employee> actualList = employeeRepository.findByDepartment(expectedDepId);

        SoftAssertions employeeAssert = new SoftAssertions();
        employeeAssert.assertThat(actualList).hasSizeGreaterThan(0);
        employeeAssert.assertThat(actualList.get(0).getDepartmentId()).isEqualTo(expectedDepId);
        employeeAssert.assertAll();
    }

    @Test
    public void findByOrganization_validId_returnObject() {
        Long expectedOrgId = 1L;
        List<Employee> actualList = employeeRepository.findByOrganization(expectedOrgId);

        SoftAssertions employeeAssert = new SoftAssertions();
        employeeAssert.assertThat(actualList).hasSizeGreaterThan(0);
        employeeAssert.assertThat(actualList.get(0).getOrganizationId()).isEqualTo(expectedOrgId);
        employeeAssert.assertAll();
    }
}
