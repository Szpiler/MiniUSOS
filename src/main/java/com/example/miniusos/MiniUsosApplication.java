package com.example.miniusos;

import com.example.miniusos.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class MiniUsosApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniUsosApplication.class, args);
    }

}
