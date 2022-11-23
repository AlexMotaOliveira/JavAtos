package br.com.javatos.cursos.controller;

import br.com.javatos.cursos.model.Curso;
import br.com.javatos.cursos.repository.CursoRepository;
import br.com.javatos.cursos.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    public Curso salvar (@RequestBody Curso curso){
        return cursoService.salvar(curso);
    }
}
