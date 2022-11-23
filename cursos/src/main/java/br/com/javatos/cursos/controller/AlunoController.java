package br.com.javatos.cursos.controller;

import br.com.javatos.cursos.model.Aluno;
import br.com.javatos.cursos.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno){
        return alunoService.salvar(aluno);
    }

    @GetMapping
    public List<Aluno> listarTodos(){
        return alunoService.listarTodos();
    }
}
