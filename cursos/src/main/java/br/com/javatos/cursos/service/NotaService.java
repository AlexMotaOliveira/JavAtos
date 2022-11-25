package br.com.javatos.cursos.service;

import br.com.javatos.cursos.model.Nota;
import br.com.javatos.cursos.repository.NotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NotaService {

    private final NotaRepository notaRepository;

    public Nota salvar(Nota nota) {
        return notaRepository.save(nota);
    }

    public List<Nota> listarTodos() {
        return notaRepository.findAll();
    }
}
