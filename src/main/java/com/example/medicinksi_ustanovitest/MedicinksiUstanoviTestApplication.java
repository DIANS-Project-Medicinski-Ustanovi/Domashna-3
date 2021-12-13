package com.example.medicinksi_ustanovitest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MedicinksiUstanoviTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicinksiUstanoviTestApplication.class, args);
    }

}
