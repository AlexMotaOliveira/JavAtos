package br.com.javatos.cursos.controller2;

import br.com.javatos.cursos.model.Nota;
import br.com.javatos.cursos.service.NotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/nota")
public class NotaController {

    private final NotaService notaService;

    @PostMapping
    public Nota salvar(@RequestBody Nota nota){
        return notaService.salvar(nota);
    }

    @GetMapping
    public List<Nota> listarTodos(){
        return notaService.listarTodos();
    }


}
