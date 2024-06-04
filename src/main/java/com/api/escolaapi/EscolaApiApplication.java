package com.api.escolaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.sampled.Port;

@SpringBootApplication
public class EscolaApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(EscolaApiApplication.class, args);
        System.out.println("Aplicação está rodando...");
        System.out.println("http://localhost:8080/");
    }
}
