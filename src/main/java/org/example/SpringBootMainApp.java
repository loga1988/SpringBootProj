package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ImportAutoConfiguration
@ComponentScan(basePackages = "org.example")
public class SpringBootMainApp {
    public static void main(String[] args){
        SpringApplication.run(SpringBootMainApp.class,args);
    }
}
