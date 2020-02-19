package com.xzy.fruitmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.xzy")
public class FruitMallWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(FruitMallWebApplication.class,args);
    }
}
