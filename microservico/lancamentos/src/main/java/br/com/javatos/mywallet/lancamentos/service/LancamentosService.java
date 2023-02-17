package br.com.javatos.mywallet.lancamentos.service;

import br.com.javatos.mywallet.lancamentos.model.Lancamento;
import br.com.javatos.mywallet.lancamentos.repository.LancamentosRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

  public Page<Lancamento> consultar(String descricao, @NonNull String dataInicial, @NonNull String dataFinal, Pageable pageable) {
    LocalDate localDateInicial = LocalDate.parse(dataInicial).minusDays(1); // 2023-02-14 - 1 = 2023-02-13
    LocalDate localDateFinal = LocalDate.parse(dataFinal).plusDays(1);         // 2023-02-14 + 1 = 2023-02-15
     return lancamentosRepository.findByDescricaoContainingIgnoreCaseAndDataDaCompraAfterAndDataDeVencimentoBefore(descricao, localDateInicial, localDateFinal, pageable);
  }
}
