package br.com.javatos.cursos.service;

import br.com.javatos.cursos.model.Disciplina;
import br.com.javatos.cursos.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public Disciplina salvar(Disciplina  disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> listarTodos() {
        return disciplinaRepository.findAll();
    }
}
