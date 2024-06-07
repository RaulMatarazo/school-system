package com.api.escolaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EscolaApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(EscolaApiApplication.class, args);
        System.out.println("A aplicação está rodando...");
        System.out.println("Desenvolvido por @raulmatarazo");
        System.out.println("Clique aqui para acessar o projeto: http://localhost:8080/");
    }
}
