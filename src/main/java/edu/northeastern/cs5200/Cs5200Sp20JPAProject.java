package edu.northeastern.cs5200;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Cs5200Sp20JPAProject extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Cs5200Sp20JPAProject.class, args);
    }

    @Override
    protected SpringApplicationBuilder
    configure(SpringApplicationBuilder application) {
        return application.sources(
                Cs5200Sp20JPAProject.class);
    }

}
