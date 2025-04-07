package com.epsilonnet.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RestApiApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(RestApiApplication.class, args);
        Environment env = context.getEnvironment();
        System.out.println("Active Profile: " + env.getActiveProfiles()[0]);
    }

}
