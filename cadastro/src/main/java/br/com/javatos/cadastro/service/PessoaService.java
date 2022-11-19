package br.com.javatos.cadastro.service;

import br.com.javatos.cadastro.model.Pessoa;
import br.com.javatos.cadastro.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
        if (byCpf.isEmpty() && byEmail.isEmpty()) {
            pessoaModel = pessoaRepository.save(pessoa);
            log.info("Objeto salvo {}:", pessoaModel);
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
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não localizado"));
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
        pessoaRepository.deleteByCpf(cpf);
    }
}
