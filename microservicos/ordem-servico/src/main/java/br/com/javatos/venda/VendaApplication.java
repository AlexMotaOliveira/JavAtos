package br.com.javatos.venda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendaApplication.class, args);
	}

}
