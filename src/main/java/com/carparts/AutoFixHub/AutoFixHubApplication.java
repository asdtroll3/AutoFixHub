package com.carparts.AutoFixHub;

import com.carparts.AutoFixHub.data.entity.TermekEntity;
import com.carparts.AutoFixHub.data.repository.TermekRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutoFixHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoFixHubApplication.class, args);
	}

}
