package com.ssjy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.ssjy")
public class SsjyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsjyApplication.class, args);
    }

}
