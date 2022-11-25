package br.com.javatos.cursos.service;

import br.com.javatos.cursos.model.Endereco;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EnderecoService {

//    private final RestTemplate restTemplate;

    public Endereco getEndereco(String cep) {
        String Url = "https://viacep.com.br/ws/" + cep + "/json";
        Endereco endereco = new RestTemplate().getForObject(Url, Endereco.class);

        return endereco;
    }
}
