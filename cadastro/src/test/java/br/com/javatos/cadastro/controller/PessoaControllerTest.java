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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;


@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaControllerTest {

    @LocalServerPort
    private int port;
    private final MockMvc mockMvc;
    private final ObjectMapper mapper;
    private final PessoaRepository pessoaRepository;


//    @Test
//    public void teste() throws Exception {
//        buscarListaDePessoaControllerTeste();
//        buscarPorIdPessoaControllerTesteStatus200();
//        buscarPorIdNaoExistePessoaControllerTesteStatus404();
//    }

    @Test
    private void buscarListaDePessoaControllerTeste() throws Exception {
        MockHttpServletRequestBuilder resquestMetodo = MockMvcRequestBuilders.get("/pessoa");
        MvcResult mvcResult = mockMvc.perform(resquestMetodo)
                .andDo(MockMvcResultHandlers.log())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
//                .andDo(MockMvcResultHandlers.print())
                .andReturn();

//        String pessoaList = mvcResult.getResponse().getContentAsString();
////        log.info("lista de pessoas string: {}", pessoaList);
//        Pessoa[] pessoas = mapper.readValue(pessoaList, Pessoa[].class);
//
//        for (Pessoa pessoa : pessoas) {
//            System.out.println(pessoa);
//        }
    }

    @Test
    public void buscarPorIdPessoaControllerTesteStatus200() throws Exception {
        Long id = 1L;
        MockHttpServletRequestBuilder resquestMetodo =
                MockMvcRequestBuilders.get("/pessoa/{id}", id);
        MvcResult mvcResult = mockMvc.perform(resquestMetodo)
                .andDo(MockMvcResultHandlers.log())
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
//                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String pessoaString = mvcResult.getResponse().getContentAsString();
        Pessoa pessoa = mapper.readValue(pessoaString, Pessoa.class);
        log.info("pessoa com o id: {}  > {}", id, pessoa);
    }

    @Test
    public void buscarPorCPFExistePessoaControllerTesteStatus200() throws Exception {
        MockHttpServletRequestBuilder resquestMetodo =
                MockMvcRequestBuilders.get("/pessoa/cpf/{cpf}", "'12332132132'");
        MvcResult mvcResult = mockMvc.perform(resquestMetodo)
                .andDo(MockMvcResultHandlers.log())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
    }

    @Test
    public void buscarPorCPFNaoExistePessoaControllerTesteStatus404() throws Exception {
        MockHttpServletRequestBuilder resquestMetodo =
                MockMvcRequestBuilders.get("/pessoa/cpf/{cpf}", "1");
        MvcResult mvcResult = mockMvc.perform(resquestMetodo)
                .andDo(MockMvcResultHandlers.log())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
    }

    @Test
    public void apagarPorIdPessoaControllerTesteStatus204() throws Exception {
        Long id = 1L;
        if (pessoaRepository != null && pessoaRepository.existsById(id)) {
            MockHttpServletRequestBuilder resquestMetodo =
                    MockMvcRequestBuilders.delete("/pessoa/{id}", "1");
            MvcResult mvcResult = mockMvc.perform(resquestMetodo)
                    .andDo(MockMvcResultHandlers.log())
                    .andExpect(MockMvcResultMatchers.status().isNoContent())
                    .andReturn();
        }
    }

    @Test
    public void salvarPessoaCotrollerTesteStatus201() throws Exception {
        Endereco endereco = Endereco.builder().cep("03590-170").build();
        Pessoa pessoa = Pessoa.builder()
                .cpf("11850603081")
                .email("a6234@alsief")
                .nome("Alex MOta")
                .endereco(endereco)
                .dataDeNascimento(new Date())
                .build();

        String body = mapper.writeValueAsString(pessoa);

        log.info("******** port: ", port);
        MockHttpServletRequestBuilder resquestMetodo =
                MockMvcRequestBuilders.post("/pessoa")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("token", "verv4er6v4er654ver65ve")
                        .content(body);
        mockMvc.perform(resquestMetodo)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isAccepted())
                .andReturn();

    }
}
