package br.com.javatos.cadastro.service;


import br.com.javatos.cadastro.exception.errors.DuplicacaoCadastroException;
import br.com.javatos.cadastro.model.Endereco;
import br.com.javatos.cadastro.model.Pessoa;
import br.com.javatos.cadastro.repository.PessoaRepository;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
//@RunWith(SpringRunner.class) // Junit 4
public class PessoaServiceTest {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaRepository pessoaRepository;

    @BeforeEach
    void setUp(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Alex");
        pessoa.setId(1L);
        pessoa.setCpf("32132132196");
        pessoa.setEmail("Alex_a@aaaaa");
        Endereco endereco = new Endereco();
        endereco.setCep("03590170");
        pessoa.setDataDeNascimento(new Date());
        pessoa.setEndereco(endereco);
        pessoaService.salvar(pessoa);
    }

    @AfterEach
    void setDown(){
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
        endereco.setCep("03590-170");
        pessoa.setDataDeNascimento(new Date());

        pessoa.setEndereco(endereco);

//        Assert.assertThrows(DuplicacaoCadastroException.class, () -> pessoaService.salvar(pessoa));
        Assert.assertNotNull(pessoaService.salvar(pessoa));
    }

    @Test
    public void buscarPessoaPorCpf() {
        String cpf = "32132132196";
        Pessoa pessoa = pessoaService.buscarPorCpf(cpf).getBody();
        Assert.assertTrue("cpf esta correto", pessoa.getCpf().equals(cpf));

    }
}
