package br.com.javatos.cadastro.service;


import br.com.javatos.cadastro.model.Endereco;
import br.com.javatos.cadastro.model.Pessoa;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
//@RunWith(SpringRunner.class) // Junit 4
public class PessoaServiceTest {

    @Autowired
    private PessoaService pessoaService;

    @Test
    public void salvarPessoaNoBancoDeDados() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Alex");
        pessoa.setId(1L);
        pessoa.setCpf("12312312341");
        pessoa.setEmail("a@a");
        Endereco endereco = new Endereco();
        endereco.setCep("03590170");
        pessoa.setDataDeNascimento(new Date());

        pessoa.setEndereco(endereco);

//        assertThrows(DuplicacaoCadastroException.class,
//                () -> pessoaService.salvar(pessoa));
        Assert.assertNotNull(pessoaService.salvar(pessoa));
    }

    @Test
    public void buscarPessoaPorCpf() {
        String cpf = "12312312341";
        Pessoa pessoa = pessoaService.buscarPorCpf(cpf).getBody();
        Assert.assertTrue("cpf esta correto", pessoa.getCpf().equals(cpf));

    }
}
