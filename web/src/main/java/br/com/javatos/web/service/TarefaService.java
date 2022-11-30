package br.com.javatos.web.service;

import br.com.javatos.web.model.Tarefa;
import br.com.javatos.web.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public void salvar(Tarefa tarefa) {
        tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listarTodos() {
        return tarefaRepository.findAll();
    }

    public Tarefa buscar(long id) {
        return tarefaRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        tarefaRepository.deleteById(id);
    }
}
