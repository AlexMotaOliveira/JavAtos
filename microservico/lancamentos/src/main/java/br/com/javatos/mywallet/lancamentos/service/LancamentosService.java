package br.com.javatos.mywallet.lancamentos.service;

import br.com.javatos.mywallet.lancamentos.model.Lancamento;
import br.com.javatos.mywallet.lancamentos.repository.LancamentosRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LancamentosService {

  private final LancamentosRepository lancamentosRepository;

  public LancamentosService(LancamentosRepository lancamentosRepository) {
    this.lancamentosRepository = lancamentosRepository;
  }

  public Lancamento salvar(Lancamento lancamento) {
    return lancamentosRepository.save(lancamento);
  }

  public List<Lancamento> consultar() {
    return lancamentosRepository.findAll();
  }

  public void deletar(Long code) {
    lancamentosRepository.deleteById(code);
  }

  public List<Lancamento> consultarporCode(Long code) {
    log.info("busca da lista de Lancamentos no banco de dados, code: {}", code);
    return lancamentosRepository.findByCode(code);
  }

  public List<Lancamento> consultar(String descricao, String dataInicial, String dataFinal) {
      return lancamentosRepository
        .findByDescricaoContainingIgnoreCaseAndDataDaCompraContainingIgnoreCaseOrAndDataDeVencimentoContainingIgnoreCase(descricao, dataInicial, dataFinal);
  }
}
