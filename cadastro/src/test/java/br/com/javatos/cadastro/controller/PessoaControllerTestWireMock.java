package br.com.javatos.cadastro.controller;


import br.com.javatos.cadastro.exception.errors.BadArgumentsException;
import br.com.javatos.cadastro.exception.errors.InternalException;
import br.com.javatos.cadastro.exception.errors.ResourceNotFoundException;
import br.com.javatos.cadastro.model.Endereco;
import br.com.javatos.cadastro.model.Pessoa;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;



@AutoConfigureMockMvc
@ActiveProfiles("wiremock")
@AutoConfigureWireMock(port = 0)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PessoaControllerTestWireMock {

    private final ObjectMapper mapper;
    private final MockMvc mockMvc;

    private Pessoa pessoa;

    @BeforeEach
    void setUp() {
        String cpf = "12312312341";
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Alex Mota");
        pessoa.setCpf(cpf);
        pessoa.setEmail("aa@aaaa");
        pessoa.setDataDeNascimento(new Date());
        Endereco endereco = new Endereco();
        endereco.setCep("00000200");
        pessoa.setEndereco(endereco);
        this.pessoa = pessoa;
    }

    @Test
    @DisplayName("salvar")
    @Order(4)
    void salvarPessaController() throws Exception {
        pessoa.getEndereco().setCep("00000200");

        String request = mapper.writeValueAsString(pessoa);

        mockMvc.perform(MockMvcRequestBuilders.post("/pessoa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Order(5)
    @DisplayName("salvar com o email duplicado")
    void salvarPessaControllerEmailDuplicado() throws Exception {
        pessoa.getEndereco().setCep("00000200");
        pessoa.setCpf("51092460098");
        String request = mapper.writeValueAsString(pessoa);

        mockMvc.perform(MockMvcRequestBuilders.post("/pessoa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Order(6)
    @DisplayName("salvar com o cpf duplicado")
    void salvarPessaControllerCPFDuplicado() throws Exception {
        pessoa.getEndereco().setCep("00000200");
        pessoa.setEmail("a@a");
        String request = mapper.writeValueAsString(pessoa);

        mockMvc.perform(MockMvcRequestBuilders.post("/pessoa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("salvar erro 400")
    @Order(1)
    void salvarPessaControllerErro400AoConsultatCep() throws Exception {
        pessoa.getEndereco().setCep("00000400");

        String request = mapper.writeValueAsString(pessoa);

        mockMvc.perform(MockMvcRequestBuilders.post("/pessoa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(result -> assertNotNull(result.getResolvedException()))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof BadArgumentsException))
                .andExpect(MockMvcResultMatchers.status().is(400))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Order(2)
    @DisplayName("salvar erro 404")
    void salvarPessaControllerErro404AoConsultatCep() throws Exception {
        pessoa.getEndereco().setCep("00000404");

        String request = mapper.writeValueAsString(pessoa);

        mockMvc.perform(MockMvcRequestBuilders.post("/pessoa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(result -> assertNotNull(result.getResolvedException()))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ResourceNotFoundException))
                .andExpect(MockMvcResultMatchers.status().is(404))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @Order(3)
    @DisplayName("salvar erro 500")
    void salvarPessaControllerErro500AoConsultatCep() throws Exception {
        pessoa.getEndereco().setCep("00000500");

        String request = mapper.writeValueAsString(pessoa);

        mockMvc.perform(MockMvcRequestBuilders.post("/pessoa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request))
                .andExpect(result -> assertNotNull(result.getResolvedException()))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof InternalException))
                .andExpect(MockMvcResultMatchers.status().is(500))
                .andDo(MockMvcResultHandlers.print());
    }
}


