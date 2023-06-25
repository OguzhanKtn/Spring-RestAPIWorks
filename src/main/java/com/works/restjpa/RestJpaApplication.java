package com.works.restjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestJpaApplication.class, args);
    }

}
