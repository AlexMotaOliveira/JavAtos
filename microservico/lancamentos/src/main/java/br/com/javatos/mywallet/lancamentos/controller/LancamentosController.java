package br.com.javatos.mywallet.lancamentos.controller;


import br.com.javatos.mywallet.lancamentos.model.Lancamento;
import br.com.javatos.mywallet.lancamentos.service.LancamentosService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin()
public class LancamentosController {

  private LancamentosService lancamentosService;

  public LancamentosController(LancamentosService lancamentosService) {
    this.lancamentosService = lancamentosService;
  }

  @GetMapping
  public Page<Lancamento> consultar(@RequestParam(value = "descricao", required = false, defaultValue = "") String descricao,
                                    @RequestParam(value = "dataInicial", required = false, defaultValue = "2023-01-01") String dataInicial,
                                    @RequestParam(value = "dataFinal", required = false, defaultValue = "3000-12-31") String dataFinal,
//                                    @RequestParam(value = "itensPorPagina", required = false, defaultValue = "10") int itensPorPagina,
                                    Pageable pageable) {
//    Pageable pageable1 = PageRequest.of(0, itensPorPagina);
    return lancamentosService.consultar(descricao, dataInicial, dataFinal, pageable);
  }


  @CacheEvict(cacheNames = "ListaDeCashePorCode") // ele limpa o Cache
  @PostMapping
  public Lancamento salvar(@RequestBody @Valid Lancamento lancamento) {
    return lancamentosService.salvar(lancamento);
  }

  @DeleteMapping("/{Code}")
  public void apagar(@PathVariable Long Code) {
    lancamentosService.deletar(Code);
  }

  @Cacheable(cacheNames = "ListaDeCashePorCode", key = "#code")
  // retorna uma lista com 1MILHÃO lancamentos 2minuto  // com CACHE 1s
  // code = 1   {chave: a@alex.com , valor: [{}]}}
  @GetMapping("/{code}")
  public List<Lancamento> consultarporCode(@PathVariable Long email) {
    return lancamentosService.consultarporCode(email);
  }

  @PutMapping
  public Lancamento alterar(@RequestBody @Valid Lancamento lancamento) {
    return lancamentosService.alterar(lancamento);
  }
}
