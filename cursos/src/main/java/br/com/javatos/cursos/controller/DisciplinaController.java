package br.com.javatos.cursos.controller;

import br.com.javatos.cursos.model.Disciplina;
import br.com.javatos.cursos.service.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
