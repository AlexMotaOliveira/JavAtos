package br.com.javatos.controller;

import br.com.javatos.model.Aluno;
import br.com.javatos.repository.AlunoRepository;
import br.com.javatos.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlunoController {

    @Autowired
    public AlunoService alunoService;

    @PostMapping("/aluno") // metodo e recurso = URI
    public Aluno salvar(@RequestBody Aluno aluno) {
        return alunoService.salvar(aluno);
    }

    @GetMapping(value = "/aluno", consumes = MediaType.ALL_VALUE)
    public List<Aluno> buscarTodosAlunos(){
        return  alunoService.buscarTodosAlunos();
    }

}
