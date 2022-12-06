package br.com.javatos.web.repository;

import br.com.javatos.web.model.Tarefa;
import br.com.javatos.web.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}
