package br.com.javatos.web.service;

import br.com.javatos.web.model.Tarefa;
import br.com.javatos.web.model.Usuario;
import br.com.javatos.web.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public void salvar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

}
