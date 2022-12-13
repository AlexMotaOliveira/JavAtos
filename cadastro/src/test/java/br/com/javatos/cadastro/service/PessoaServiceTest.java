package br.com.javatos.cadastro.service;


import br.com.javatos.cadastro.model.Endereco;
import br.com.javatos.cadastro.model.Pessoa;
import br.com.javatos.cadastro.repository.PessoaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import java.util.Date;

@SpringBootTest
//@RunWith(SpringRunner.class) // Junit 4
@ActiveProfiles("wiremock")
@AutoConfigureWireMock(port = 0)
public class PessoaServiceTest {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaRepository pessoaRepository;

    @BeforeEach
    void setUp() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Alex");
        pessoa.setId(1L);
        pessoa.setCpf("32132132196");
        pessoa.setEmail("Alex_a@aaaaa");
        Endereco endereco = new Endereco();
        endereco.setCep("00000200");
        pessoa.setDataDeNascimento(new Date());
        pessoa.setEndereco(endereco);
        pessoaService.salvar(pessoa);
    }

    @AfterEach
    void setDown() {
        pessoaRepository.deleteAll();
    }

    @Test
    public void salvarPessoaNoBancoDeDados() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Alex");
        pessoa.setId(1L);
        pessoa.setCpf("32132132");
        pessoa.setEmail("Als_a@aaaaa");
        Endereco endereco = new Endereco();
        endereco.setCep("00000200");
        pessoa.setDataDeNascimento(new Date());

        pessoa.setEndereco(endereco);

//        Assert.assertThrows(DuplicacaoCadastroException.class, () -> pessoaService.salvar(pessoa));
        pessoaService.salvar(pessoa);
    }

    @Test
    public void buscarPessoaPorCpf() {
        String cpf = "32132132196";
        Pessoa pessoa = pessoaService.buscarPorCpf(cpf).getBody();
        Assert.isTrue( pessoa.getCpf().equals(cpf),"cpf esta correto");

    }
}
