package br.com.javatos.mywallet.lancamentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.websocket.ClientEndpoint;

@EnableEurekaClient
@EnableCaching
@SpringBootApplication
public class LancamentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LancamentosApplication.class, args);
	}

}
