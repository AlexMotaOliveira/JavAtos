package br.com.javatos.cursos.controller;

import br.com.javatos.cursos.model.Curso;
import br.com.javatos.cursos.repository.CursoRepository;
import br.com.javatos.cursos.service.CursoService;
import jdk.dynalink.linker.LinkerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    public Curso salvar (@RequestBody Curso curso){
        return cursoService.salvar(curso);
    }

    @GetMapping
    public List<Curso> listarTodos(){
        return cursoService.listarTodos();
    }
}
