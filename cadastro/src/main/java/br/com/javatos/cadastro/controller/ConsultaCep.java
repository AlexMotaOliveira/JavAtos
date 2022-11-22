package br.com.javatos.cadastro.controller;

import br.com.javatos.cadastro.model.Endereco;
import br.com.javatos.cadastro.model.Pessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/cep")
public class ConsultaCep {


    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> getCep(@PathVariable String cep) {
        //localhost:8091 meu dominio
        //localhost:8090 fora do dominio
//        ResponseEntity<Endereco> responseEntity = new RestTemplate().getForEntity(url, Endereco.class);
        Endereco endereco =  buscarCep(cep);
        return ResponseEntity.ok(endereco);
    }

    @GetMapping
    public List<Endereco> getListaDePessoa() {
        String url = "http://localhost:8091/pessoa";
        List responseObject = new RestTemplate().getForObject(url, List.class);
        return responseObject;
    }

    public Endereco buscarCep(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json";
        return new RestTemplate().getForObject(url, Endereco.class);
    }
}
