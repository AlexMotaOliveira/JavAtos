package br.com.javatos.cadastro.service;

import br.com.javatos.cadastro.controller.ConsultaCep;
import br.com.javatos.cadastro.exception.errors.DuplicacaoCadastroException;
import br.com.javatos.cadastro.exception.errors.PessoaExceptionNotFound;
import br.com.javatos.cadastro.model.Endereco;
import br.com.javatos.cadastro.model.Pessoa;
import br.com.javatos.cadastro.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ConsultaCep pessoaRepositoryCep;

    public Pessoa salvar(Pessoa pessoa) {
        log.info("persistindo o objeto");
        existeCpfOuEmail(pessoa); // possivelmente lança uma exception
        Endereco endereco = pessoaRepositoryCep.buscarCep(pessoa.getEndereco().getCep());
        pessoa.setEndereco(endereco);
        Pessoa pessoaModel = pessoaRepository.save(pessoa);
        log.info("Objeto salvo {}:", pessoaModel);
        return pessoaModel;
    }

    public List<Pessoa> buscarTodos() {
        log.info("buscando a lista de pessoas no banco de dados");
        return pessoaRepository.findAll();
    }

    public Pessoa buscar(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaExceptionNotFound("Id não localizado"));
    }

    public void apagar(Long id) {
        try {
            pessoaRepository.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException("id não localizado");
        }
    }

    public ResponseEntity<Pessoa> buscarPorCpf(String cpf) {
        try {
            Optional<Pessoa> pessoa = pessoaRepository.findByCpf(cpf);
            if (pessoa.isEmpty()) {
                return ResponseEntity.notFound().build(); // status code 404
            }
            return ResponseEntity.ok(pessoa.get()); // status code 200 com um body
        } catch (RuntimeException e) {
            log.error("erro na colsulta {}", e);
        }
        return ResponseEntity.internalServerError().build(); // status code 500
    }

    public void apagarPorCpf(String cpf) {
        Optional<Pessoa> pessoa = pessoaRepository.findByCpf(cpf);
        if (pessoa.isEmpty()) {
            throw new PessoaExceptionNotFound("não foi possivel a exclusão por cpf");
        }
        pessoaRepository.deleteByCpf(cpf);
    }

    private void existeCpfOuEmail(Pessoa pessoa) {
        Optional<Pessoa> pessoaEntidadeCpf = pessoaRepository.findByCpf(pessoa.getCpf());
        Optional<Pessoa> pessoaEntidadeEmail = pessoaRepository.findByEmail(pessoa.getEmail());
        if (pessoaEntidadeEmail.isPresent()) {
            throw new DuplicacaoCadastroException("email já cadastrado");
        }
        if (pessoaEntidadeCpf.isPresent()) {
            throw new DuplicacaoCadastroException("cpf já cadastrado");
        }
    }
}
