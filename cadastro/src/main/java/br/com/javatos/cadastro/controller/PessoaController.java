package br.com.javatos.cadastro.controller;

import br.com.javatos.cadastro.model.Pessoa;
import br.com.javatos.cadastro.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    // /pessoa
    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa) {
        return pessoaService.salvar(pessoa);
    }

    @GetMapping
    public List<Pessoa> buscarTodos(){
        return pessoaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Pessoa buscar(@PathVariable Long id){
        return pessoaService.buscar(id);
    }

    @DeleteMapping("/{id}")
    public void apagar(@PathVariable Long id){
         pessoaService.apagar(id);
    }


}
