package com.endyary.samplemicroservices.department.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DepartmentRepository {
    private static final List<Department> departments = new ArrayList<>();

    static {
        Department.DepartmentBuilder depBld = new Department.DepartmentBuilder();
        departments.add(depBld.id(1L).name("Development").organizationId(1L).build());
        departments.add(depBld.id(2L).name("Operations").organizationId(1L).build());
        departments.add(depBld.id(3L).name("Development").organizationId(2L).build());
        departments.add(depBld.id(4L).name("Operations").organizationId(2L).build());
    }

    public Department add(Department department) {
        department.setId((long) (departments.size()+1));
        departments.add(department);
        return department;
    }

    public Department findById(Long id) {
        Optional<Department> department = departments.stream().filter(a -> a.getId().equals(id)).findFirst();
        return department.orElse(null);
    }

    public List<Department> findAll() {
        return departments;
    }

    public List<Department> findByOrganization(Long organizationId) {
        return departments.stream().filter(a -> a.getOrganizationId().equals(organizationId)).collect(Collectors.toList());
    }
}
