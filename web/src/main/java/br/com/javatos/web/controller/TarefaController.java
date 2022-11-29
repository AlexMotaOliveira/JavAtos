package br.com.javatos.web.controller;

import br.com.javatos.web.model.Tarefa;
import br.com.javatos.web.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tarefa")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @GetMapping
    public String abrirPagina(ModelMap modelMap) {
        modelMap.addAttribute("cadastro", "pagina de cadastro");
        return "cadastro";
    }

    @PostMapping
    public String cadastrar(Tarefa tarefa) {
        tarefaService.salvar(tarefa);
        return "cadastro";
    }

    @GetMapping("/listar")
    public String listarTarefas(ModelMap modelMap){
       List<Tarefa> tarefaList =  tarefaService.listarTodos();
       modelMap.addAttribute("tarefas", tarefaList);
       return "lista";
    }

}
