package br.com.javatos.auth.config;

import br.com.javatos.auth.config.feing.UsuarioFeing;
import br.com.javatos.auth.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

  @Autowired
  private UsuarioFeing usuarioFeing;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario usuario = usuarioFeing.findEmail(username);
    return usuario;
  }
}
