package br.com.javatos.mywallet.lancamentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class LancamentosApplication {

	public static void main(String[] args) {
		SpringApplication.run(LancamentosApplication.class, args);
	}

}
