package eu.nenkov.skeleton_projects.spring;

import eu.nenkov.skeleton_projects.spring.util.SkeletonConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Log4j2
@SpringBootApplication
public class SkeletonSpringApp {

    public static void main(String[] args) {
        log.info(SkeletonConstants.SOME_TEXT);
        SpringApplication.run(SkeletonSpringApp.class, args);
    }

}
