package com.uob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.uob.model")
public class VendingMachine {

    public static void main(String[] args) {
        SpringApplication.run(VendingMachine.class, args);
    }

}
