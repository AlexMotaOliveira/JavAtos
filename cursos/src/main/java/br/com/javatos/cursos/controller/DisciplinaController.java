package br.com.javatos.cursos.controller;

import br.com.javatos.cursos.model.Curso;
import br.com.javatos.cursos.model.Disciplina;
import br.com.javatos.cursos.service.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/disciplina")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @PostMapping
    public Disciplina salvar(@RequestBody Disciplina disciplina) {
        return disciplinaService.salvar(disciplina);
        //TODO
        // ok receber uma Disciplina
        //  validar a a Disciplina
        // ok vou salvar no BD
        // ok retornar ou não a disciplina
    }

    @GetMapping
    public List<Disciplina> listarTodos(){
        return disciplinaService.listarTodos();
    }
}
