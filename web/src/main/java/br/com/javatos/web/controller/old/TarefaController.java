package br.com.javatos.web.controller.old;

import br.com.javatos.web.model.Tarefa;
import br.com.javatos.web.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @GetMapping("/tarefa")
    public String abrirPagina(ModelMap modelMap) {
        modelMap.addAttribute("tarefa", new Tarefa());
        return "buttons";
    }

    @PostMapping("/tarefa")
    public String cadastrar(@Valid Tarefa tarefa, BindingResult result) {
        if (result.hasErrors()) {
            return "tarefa/cadastro-tarefa";
        }
        tarefaService.salvar(tarefa);
        return "redirect:/tarefa/listar"; // passar uma URI
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = {"/tarefa/listar"})
    public String listarTarefas(Model model) {
        List<Tarefa> tarefaList = tarefaService.listarTodos();
        model.addAttribute("tarefas", tarefaList);
        return "tables";
    }

    @GetMapping("/tarefa/{id}")
    public ModelAndView alterar(@PathVariable long id) {
        ModelAndView view = new ModelAndView("tarefa/cadastro-tarefa");

        Tarefa tarefa = tarefaService.buscar(id);
        view.addObject(tarefa);
        return view;
    }


    @RequestMapping(method = {RequestMethod.POST, RequestMethod.DELETE}, value = "/tarefa/excluir")
    public String excluir(Long id) {
        tarefaService.excluir(id);
        return "redirect:/tarefa/listar"; // passar uma URI
    }
}
