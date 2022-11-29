package br.com.javatos.web.controller;

import br.com.javatos.web.model.Tarefa;
import br.com.javatos.web.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @GetMapping("/tarefa")
    public String abrirPagina(ModelMap modelMap) {
        modelMap.addAttribute("cadastro", "pagina de cadastro");
        modelMap.addAttribute("tarefa", new Tarefa());
        return "cadastro";
    }

    @PostMapping("/tarefa")
    public String cadastrar(Tarefa tarefa) {
        tarefaService.salvar(tarefa);
        return "redirect:/tarefa/listar"; // passar uma URI
    }

    @GetMapping({
            "/tarefa/listar", "/"
    })
    public String listarTarefas(Model model) {
        List<Tarefa> tarefaList = tarefaService.listarTodos();
        model.addAttribute("tarefas", tarefaList);
        return "lista";
    }

    @GetMapping("/tarefa/{id}")
    public ModelAndView alterar(@PathVariable long id) {
        ModelAndView view = new ModelAndView("cadastro");

        Tarefa tarefa = tarefaService.buscar(id);
        view.addObject(tarefa);
        return view;
    }

}
