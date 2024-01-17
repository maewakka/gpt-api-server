package com.woo.gptapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GptApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GptApiApplication.class, args);
    }

}
