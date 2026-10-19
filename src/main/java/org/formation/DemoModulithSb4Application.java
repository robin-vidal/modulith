package org.formation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DemoModulithSb4Application {

    public static void main(String[] args) {
        SpringApplication.run(DemoModulithSb4Application.class, args);
    }

}
