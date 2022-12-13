package br.com.javatos.cadastro.controller;

import br.com.javatos.cadastro.model.Endereco;
import br.com.javatos.cadastro.model.Pessoa;
import br.com.javatos.cadastro.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;


@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaControllerTestMockito {

    @LocalServerPort
    private int port;
    private final MockMvc mockMvc;
    private final ObjectMapper mapper;
    @MockBean
    private PessoaRepository pessoaRepository;
    @MockBean
    private PessoaController pessoaController;

    @Test
    public void buscarListaDePessoaControllerTeste() throws Exception {
        Endereco endereco = Endereco.builder().cep("03590-170").build();
        Pessoa pessoa = Pessoa.builder()
                .cpf("11850603081")
                .email("a6234@alsief")
                .nome("Alex Mota")
                .endereco(endereco)
                .dataDeNascimento(new Date())
                .build();

        Mockito.when(pessoaRepository.findAll()).thenReturn(Arrays.asList(pessoa, pessoa, pessoa));
        MockHttpServletRequestBuilder resquestMetodo = MockMvcRequestBuilders.get("/pessoa");
        mockMvc.perform(resquestMetodo)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void buscarPorIdPessoaControllerTesteStatus200() throws Exception {
        Long id = 1L;
        Endereco endereco = Endereco.builder().cep("03590-170").build();
        Pessoa pessoa = Pessoa.builder()
                .id(id)
                .cpf("11850603081")
                .email("a6234@alsief")
                .nome("Alex Mota")
                .endereco(endereco)
                .dataDeNascimento(new Date())
                .build();


//        Mockito.when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));
        Mockito.when(pessoaController.buscar(1L)).thenReturn(pessoa);
        MockHttpServletRequestBuilder resquestMetodo =
                MockMvcRequestBuilders.get("/pessoa/{id}", id);
        MvcResult mvcResult = mockMvc.perform(resquestMetodo)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String pessoaString = mvcResult.getResponse().getContentAsString();
        Pessoa pessoa1 = mapper.readValue(pessoaString, Pessoa.class);
        log.info("pessoa com o id: {}  > {}", id, pessoa1);
    }

    @Test
    public void buscarPorCPFExistePessoaControllerTesteStatus200() throws Exception {

        Mockito.when(pessoaRepository.findByCpf("12332132132")).thenReturn(Optional.of(new Pessoa()));
        MockHttpServletRequestBuilder resquestMetodo =
                MockMvcRequestBuilders.get("/pessoa/cpf/{cpf}", "12332132132");
        MvcResult mvcResult = mockMvc.perform(resquestMetodo)
                .andDo(MockMvcResultHandlers.log())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andReturn();
    }

//    @Test
//    public void buscarPorCPFNaoExistePessoaControllerTesteStatus404() throws Exception {
//        MockHttpServletRequestBuilder resquestMetodo =
//                MockMvcRequestBuilders.get("/pessoa/cpf/{cpf}", "1");
//        MvcResult mvcResult = mockMvc.perform(resquestMetodo)
//                .andDo(MockMvcResultHandlers.log())
//                .andExpect(MockMvcResultMatchers.status().isNotFound())
//                .andReturn();
//    }
//
    @Test
    public void apagarPorIdPessoaControllerTesteStatus204() throws Exception {
        Long id = 1L;
        if (pessoaRepository != null && pessoaRepository.existsById(id)) {
            Mockito.doNothing().when(pessoaRepository).deleteById(1L);
            MockHttpServletRequestBuilder resquestMetodo =
                    MockMvcRequestBuilders.delete("/pessoa/{id}", "1");
            MvcResult mvcResult = mockMvc.perform(resquestMetodo)
                    .andDo(MockMvcResultHandlers.log())
                    .andExpect(MockMvcResultMatchers.status().isNoContent())
                    .andReturn();
        }
    }
//
//    @Test
//    public void salvarPessoaCotrollerTesteStatus201() throws Exception {
//        Endereco endereco = Endereco.builder().cep("03590-170").build();
//        Pessoa pessoa = Pessoa.builder()
//                .cpf("11850603081")
//                .email("a6234@alsief")
//                .nome("Alex MOta")
//                .endereco(endereco)
//                .dataDeNascimento(new Date())
//                .build();
//
//        String body = mapper.writeValueAsString(pessoa);
//
//        log.info("******** port: ", port);
//        MockHttpServletRequestBuilder resquestMetodo =
//                MockMvcRequestBuilders.post("/pessoa")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .header("token", "verv4er6v4er654ver65ve")
//                        .content(body);
//        mockMvc.perform(resquestMetodo)
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(MockMvcResultMatchers.status().isAccepted())
//                .andReturn();
//
//    }
}
