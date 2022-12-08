package br.com.javatos.cadastro.model;


import br.com.javatos.cadastro.exception.errors.DuplicacaoCadastroException;
import org.junit.Test;
import org.springframework.util.Assert;

import static org.springframework.util.Assert.notNull;

public class PessoaTest {

    @Test
    public void criarPessoa_OK_passando_Nome() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Alex Mota");
        pessoa.setId(1L);
        pessoa.setCpf("12312312341");
        pessoa.setEmail("a@a");
        pessoa.getNome();
        pessoa.getId();
        pessoa.getEndereco();
        pessoa.getEmail();

        Assert.isTrue(pessoa.getNome().equals("Alex Mota"));
        notNull(pessoa, "não pode ser nulo");
    }
}
