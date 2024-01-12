package com.example.Proyecton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
@EntityScan(basePackages = "com.example.Proyecton.entities")
public class ProyectonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectonApplication.class, args);
	}

}
