package com.endyary.samplemicroservices.employee.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private static final List<Employee> employees = new ArrayList<>();

    static {
        Employee.EmployeeBuilder empBld = new Employee.EmployeeBuilder();
        employees.add(empBld.id(1L).organizationId(1L).departmentId(1L).name("John Smith").age(34).position("Analyst").build());
        employees.add(empBld.id(2L).organizationId(1L).departmentId(1L).name("Darren Hamilton").age(37).position("Manager").build());
        employees.add(empBld.id(3L).organizationId(1L).departmentId(1L).name("Tom Scott").age(26).position("Developer").build());
        employees.add(empBld.id(4L).organizationId(1L).departmentId(2L).name("Anna London").age(39).position("Analyst").build());
        employees.add(empBld.id(5L).organizationId(1L).departmentId(2L).name("Patrick Dempsey").age(27).position("Developer").build());
        employees.add(empBld.id(6L).organizationId(2L).departmentId(3L).name("Kevin Price").age(38).position("Developer").build());
        employees.add(empBld.id(7L).organizationId(2L).departmentId(3L).name("Ian Scott").age(34).position("Developer").build());
        employees.add(empBld.id(8L).organizationId(2L).departmentId(3L).name("Andrew Campton").age(39).position("Manager").build());
        employees.add(empBld.id(9L).organizationId(2L).departmentId(4L).name("Steve Franklin").age(25).position("Developer").build());
        employees.add(empBld.id(10L).organizationId(2L).departmentId(3L).name("Elisabeth Smith").age(30).position("Developer").build());
    }

    public Employee add(Employee employee) {
        employee.setId((long) (employees.size()+1));
        employees.add(employee);
        return employee;
    }

    public Employee findById(Long id) {
        return employees.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> findAll() {
        return employees;
    }

    public List<Employee> findByDepartment(Long departmentId) {
        return employees.stream()
                .filter(a -> a.getDepartmentId().equals(departmentId))
                .toList();
    }

    public List<Employee> findByOrganization(Long organizationId) {
        return employees.stream()
                .filter(a -> a.getOrganizationId().equals(organizationId))
                .toList();
    }
}
