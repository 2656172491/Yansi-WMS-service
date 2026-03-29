package org.example.yansispringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*")
public class YansiSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(YansiSpringbootApplication.class, args);
    }

}
