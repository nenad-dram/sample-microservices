package com.endyary.samplemicroservices.organization.domain;

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

}
