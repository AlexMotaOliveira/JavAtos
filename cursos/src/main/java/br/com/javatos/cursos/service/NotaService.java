package br.com.javatos.cursos.service;

import br.com.javatos.cursos.repository.NotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NotaService {

    private final NotaRepository notaRepository;

}
