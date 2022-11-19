package br.com.javatos.cadastro.service;

import br.com.javatos.cadastro.model.Pessoa;
import br.com.javatos.cadastro.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public Pessoa salvar(Pessoa pessoa) {
        log.info("persistindo o objeto");
        Pessoa pessoaModel = null;
        Optional<Pessoa> byCpf = pessoaRepository.findByCpf(pessoa.getCpf());
        Optional<Pessoa> byEmail = pessoaRepository.findByEmail(pessoa.getEmail());
        if (!byCpf.isPresent() && !byEmail.isPresent()) {
            pessoaModel = pessoaRepository.save(pessoa);
            log.info("Objeto salvo {}", pessoaModel);
        } else {
            log.info("cpf ou email já cadastrado");
        }
        return pessoaModel;
    }

    public List<Pessoa> buscarTodos() {
        log.info("buscando a lista de pessoas no banco de dados");
        return pessoaRepository.findAll();
    }

    public Pessoa buscar(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    public void apagar(Long id) {
        pessoaRepository.deleteById(id);
    }

    public Pessoa buscarPorCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf).orElse(null);
    }

    public void apagarPorCpf(String cpf) {
        pessoaRepository.deleteByCpf(cpf);
    }
}
