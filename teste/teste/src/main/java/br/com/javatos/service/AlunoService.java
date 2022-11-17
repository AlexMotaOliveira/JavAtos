package br.com.javatos.service;

import br.com.javatos.model.Aluno;
import br.com.javatos.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno salvar(Aluno aluno) {

        return alunoRepository.save(aluno);
    }


    public List<Aluno> buscarTodosAlunos() {
        return alunoRepository.findAll();
    }
}
