package br.com.javatos.cadastro.service;


import br.com.javatos.cadastro.exception.errors.DuplicacaoCadastroException;
import br.com.javatos.cadastro.model.Endereco;
import br.com.javatos.cadastro.model.Pessoa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PessoaServiceTest {

    @Autowired
    private PessoaService pessoaService;

    @Test(expected = DuplicacaoCadastroException.class)
    public void salvarPessoaNoBancoDeDados() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setCpf("12312312341");
        pessoa.setEmail("a@a");
        Endereco endereco = new Endereco();
        endereco.setCep("03590170");
        pessoa.setDataDeNascimento(new Date());

        pessoa.setEndereco(endereco);
        try {

            pessoaService.salvar(pessoa);
        }catch (DuplicacaoCadastroException e){
            throw new DuplicacaoCadastroException("nok");
        }
    }
}
