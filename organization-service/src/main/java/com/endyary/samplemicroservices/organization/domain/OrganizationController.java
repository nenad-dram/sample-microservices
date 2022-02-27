package com.endyary.samplemicroservices.organization.domain;

import com.endyary.samplemicroservices.organization.department.DepartmentClient;
import com.endyary.samplemicroservices.organization.employee.EmployeeClient;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrganizationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    private final OrganizationRepository repository;
    private final EmployeeClient employeeClient;
    private final DepartmentClient departmentClient;

    @PostMapping
    public Organization add(@RequestBody Organization organization) {
        LOGGER.info("Organization add: {}", organization);
        return repository.add(organization);
    }

    @GetMapping
    public List<Organization> findAll() {
        LOGGER.info("Organization find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable("id") Long id) {
        LOGGER.info("Organization find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/{id}/with-employees")
    public Organization findByIdWithEmployees(@PathVariable("id") Long id) {
        LOGGER.info("Organization find: id={}, (with employees)", id);
        Organization organization = repository.findById(id).toBuilder().build();
        organization.setEmployees(employeeClient.findByOrganization(organization.getId()));
        return organization;
    }

    @GetMapping("/{id}/with-departments")
    public Organization findByIdWithDepartments(@PathVariable("id") Long id) {
        LOGGER.info("Organization find: id={}, (with departments)", id);
        Organization organization = repository.findById(id).toBuilder().build();
        organization.setDepartments(departmentClient.findByOrganization(organization.getId()));
        return organization;
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) {
        LOGGER.info("Organization find: id={}, (with departments and employees)", id);
        Organization organization = repository.findById(id).toBuilder().build();
        organization.setDepartments(departmentClient.findByOrganizationWithEmployees(organization.getId()));
        return organization;
    }
}
