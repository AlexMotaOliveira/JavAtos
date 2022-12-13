package br.com.javatos.cadastro.controller;

import br.com.javatos.cadastro.model.Endereco;
import br.com.javatos.cadastro.model.Pessoa;
import br.com.javatos.cadastro.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;


@ActiveProfiles("wiremock")
@AutoConfigureMockMvc
@AutoConfigureWireMock(port = 0)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PessoaControllerTestWireMock {

    private final ObjectMapper mapper;
    private final MockMvc mockMvc;

    @Test
    void salvarPessaController() throws Exception {
        String cpf = "12312312341";
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Alex Mota");
        pessoa.setCpf(cpf);
        pessoa.setEmail("aa@aaaa");
        pessoa.setDataDeNascimento(new Date());
        Endereco endereco = new Endereco();
        endereco.setCep("03590170");
        pessoa.setEndereco(endereco);

        String request = mapper.writeValueAsString(pessoa);

        mockMvc.perform(MockMvcRequestBuilders.post("/pessoa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void salvarPessaControllerErro500AoConsultatCep() throws Exception {
        String cpf = "12312312341";
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Alex Mota");
        pessoa.setCpf(cpf);
        pessoa.setEmail("aa@aaaa");
        pessoa.setDataDeNascimento(new Date());
        Endereco endereco = new Endereco();
        endereco.setCep("00000000");
        pessoa.setEndereco(endereco);

        String request = mapper.writeValueAsString(pessoa);

        mockMvc.perform(MockMvcRequestBuilders.post("/pessoa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(MockMvcResultMatchers.status().is(404))
                .andDo(MockMvcResultHandlers.print());
    }
}

