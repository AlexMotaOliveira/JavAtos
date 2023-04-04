package br.com.javatos.auth.config.feing;


import br.com.javatos.auth.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "usuario", path = "/usuario/email")
public interface UsuarioFeing {

  @GetMapping("/{email}")
  Usuario findEmail(@PathVariable String email);

}
