package br.com.javatos.cadastro.controller;

import br.com.javatos.cadastro.model.Pessoa;
import br.com.javatos.cadastro.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoa")
@Slf4j
public class PessoaController {

    private final PessoaService pessoaService;

    // /pessoa
    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Pessoa salvar(@Valid @RequestBody Pessoa pessoa) {
        log.info("iniciando o cadastro de uma pessoa: {}", pessoa);
        return pessoaService.salvar(pessoa);
    }

    @GetMapping
    public List<Pessoa> buscarTodos() {
        return pessoaService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Pessoa buscar(@PathVariable Long id) {
        return pessoaService.buscar(id);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Pessoa> buscar(@PathVariable String cpf) {
        return pessoaService.buscarPorCpf(cpf);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void apagar(@PathVariable Long id) {
        log.warn("excluindo uma pessoa");
        pessoaService.apagar(id);
        log.warn("pessoa excluida")
    }

    @DeleteMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void apagar(@PathVariable String cpf) {
        pessoaService.apagarPorCpf(cpf);
    }
}
