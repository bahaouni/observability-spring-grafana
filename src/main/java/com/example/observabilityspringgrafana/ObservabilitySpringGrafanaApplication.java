package com.example.observabilityspringgrafana;

import com.example.observabilityspringgrafana.entities.Product;
import com.example.observabilityspringgrafana.repository.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ObservabilitySpringGrafanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObservabilitySpringGrafanaApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(ProductRepo ProductRepo){
		return args -> {
			ProductRepo.save(Product.builder().nom("Computer").price(23000).build());
			ProductRepo.save(Product.builder().nom("Smart Phone").price(1200).build());
			ProductRepo.save(Product.builder().nom("Printer").price(300).build());
			ProductRepo.findAll().forEach(System.out::println);
		};
	}
}
