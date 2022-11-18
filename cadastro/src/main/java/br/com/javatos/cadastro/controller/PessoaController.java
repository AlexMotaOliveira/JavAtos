package br.com.javatos.cadastro.controller;

import br.com.javatos.cadastro.model.Pessoa;
import br.com.javatos.cadastro.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    // /pessoa
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa salvar(@Valid @RequestBody Pessoa pessoa) {
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

    @GetMapping("/cpf/{cpf}")
    public Pessoa buscar(@PathVariable String cpf){
        return pessoaService.buscarPorCpf(cpf);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagar(@PathVariable Long id){
         pessoaService.apagar(id);
    }

    @DeleteMapping("/cpf/{cpf}")
    @Transactional
    public void apagar(@PathVariable String cpf){
        pessoaService.apagarPorCpf(cpf);
    }
}
