package eu.nenkov.skeleton_projects.spring.controller.rest;


import eu.nenkov.skeleton_projects.spring.controller.dto.ResourceDto;
import eu.nenkov.skeleton_projects.spring.service.ResourceAdministrationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Log4j2
@RestController("/resources")
public class ResourceController {

    final ResourceAdministrationService administrationService;

    public ResourceController(ResourceAdministrationService administrationService) {
        this.administrationService = administrationService;
    }

    @GetMapping
    public List<ResourceDto> getResources() {
        log.info("available resources request received");
        return administrationService.availableResources();
    }
}
