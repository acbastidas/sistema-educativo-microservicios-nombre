package com.sistema.matriculas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // 👈 Habilita el uso de Feign Client
public class MatriculasServicioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatriculasServicioApplication.class, args);
    }
}
