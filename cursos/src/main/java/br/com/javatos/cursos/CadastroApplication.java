package br.com.javatos.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CadastroApplication {

	public static void main(String[] args) {
		System.out.println("Oi");
		SpringApplication.run(CadastroApplication.class, args);
	}

}
