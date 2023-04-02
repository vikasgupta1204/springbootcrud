package com.v2.spingbootspringcore.spingbootspringcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.v2.spingbootspringcore.outside",
        "com.v2.spingbootspringcore.spingbootspringcore"})
public class SpingbootSpringCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingbootSpringCoreApplication.class, args);
    }

}
