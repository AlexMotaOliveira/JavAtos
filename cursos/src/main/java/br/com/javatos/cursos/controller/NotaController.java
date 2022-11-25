package br.com.javatos.cursos.controller;

import br.com.javatos.cursos.model.Nota;
import br.com.javatos.cursos.service.NotaService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/nota")
public class NotaController {

    private final NotaService notaService;

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "criado"),
            @ApiResponse(code = 500, message = "falha ao conectar com o banco de dados")
    })
    public Nota salvar(@RequestBody Nota nota){
        return notaService.salvar(nota);
    }

    @GetMapping
    public List<Nota> listarTodos(){
        return notaService.listarTodos();
    }


}
