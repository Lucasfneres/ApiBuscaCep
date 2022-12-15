package com.busca.cep.apibuscacep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
public class ApiBuscaCepApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiBuscaCepApplication.class, args);
    }

}
