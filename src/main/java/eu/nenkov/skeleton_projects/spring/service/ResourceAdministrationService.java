package eu.nenkov.skeleton_projects.spring.service;

import eu.nenkov.skeleton_projects.spring.controller.dto.ResourceDto;
import eu.nenkov.skeleton_projects.spring.dao.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceAdministrationService {

    final ResourceRepository repository;

    public ResourceAdministrationService(ResourceRepository repository) {
        this.repository = repository;
    }

    public List<ResourceDto> availableResources() {
        return null;
    }
}
