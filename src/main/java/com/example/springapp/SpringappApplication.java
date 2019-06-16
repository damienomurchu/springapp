package com.example.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Entry point to Springapp API
 */
@SpringBootApplication
@ComponentScan({"com.example.springapp.controller", "com.example.springapp.service"})
@EntityScan("com.example.springapp.model")
@EnableJpaRepositories("com.example.springapp.repository")
public class SpringappApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringappApplication.class, args);
  }

}
