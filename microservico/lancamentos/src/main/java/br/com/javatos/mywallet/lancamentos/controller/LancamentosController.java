package br.com.javatos.mywallet.lancamentos.controller;


import br.com.javatos.mywallet.lancamentos.model.Lancamentos;
import br.com.javatos.mywallet.lancamentos.service.LancamentosService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
@CrossOrigin()
public class LancamentosController {

  private LancamentosService lancamentosService;

  public LancamentosController(LancamentosService lancamentosService) {
    this.lancamentosService = lancamentosService;
  }

  @GetMapping
  public List<Lancamentos> consultar() {
    return lancamentosService.consultar();
  }

}
