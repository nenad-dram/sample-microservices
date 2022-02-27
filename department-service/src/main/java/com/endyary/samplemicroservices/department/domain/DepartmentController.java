package com.endyary.samplemicroservices.department.domain;

import com.endyary.samplemicroservices.department.employee.EmployeeClient;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    private final DepartmentRepository repository;
    private final EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department add: {}", department);
        return repository.add(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id) {
        LOGGER.info("Department find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping
    public List<Department> findAll() {
        LOGGER.info("Department find");
        return repository.findAll();
    }

    @GetMapping("/organization/{organizationId}")
    public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId) {
        LOGGER.info("Department find: organizationId={}", organizationId);
        return repository.findByOrganization(organizationId);
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
        LOGGER.info("Department find: organizationId={}, (with employees)", organizationId);
        List<Department> departments = repository.findByOrganization(organizationId);
        List<Department> responseDep = new ArrayList<>();
        departments.forEach(d -> responseDep.add(d.toBuilder().employees(employeeClient.findByDepartment(d.getId())).build()));
        return responseDep;
    }

}
