package br.com.javatos.cursos.controller;

import br.com.javatos.cursos.model.Aluno;
import br.com.javatos.cursos.service.AlunoService;
import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    @ApiOperation(value = "salvar uma aluno")
    public Aluno salvar(@RequestBody Aluno aluno){
        return alunoService.salvar(aluno);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Listar todos os alunos")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "criado"),
            @ApiResponse(code = 500, message = "falha ao conectar com o banco de dados")
    })
    public List<Aluno> listarTodos(){
        return alunoService.listarTodos();
    }

    @PutMapping
    @ApiOperation(value = "Alterar os dados de um Aluno")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "criado"),
            @ApiResponse(code = 500, message = "falha ao conectar com o banco de dados")
    })
    public Aluno alterar(@RequestBody Aluno aluno){
        return alunoService.alterar(aluno);
    }

}
