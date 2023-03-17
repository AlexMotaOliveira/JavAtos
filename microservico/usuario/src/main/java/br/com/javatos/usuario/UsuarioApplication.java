package br.com.javatos.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UsuarioApplication {
  public UsuarioApplication() {
  }

  public static void main(String[] args) {
    SpringApplication.run(UsuarioApplication.class, args);
  }
}
