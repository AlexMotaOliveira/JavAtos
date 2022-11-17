package br.com.javatos.cadastro.service;

import br.com.javatos.cadastro.model.Pessoa;
import br.com.javatos.cadastro.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> buscarTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscar(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public void apagar(Long id) {
        pessoaRepository.deleteById(id);
    }
}
