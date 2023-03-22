package br.com.javatos.mywallet.lancamentos.service;

import br.com.javatos.mywallet.lancamentos.config.RabbitConfig;
import br.com.javatos.mywallet.lancamentos.model.Email;
import br.com.javatos.mywallet.lancamentos.model.Lancamento;
import br.com.javatos.mywallet.lancamentos.repository.LancamentosRepository;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class LancamentosService {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  private final LancamentosRepository lancamentosRepository;

  public LancamentosService(LancamentosRepository lancamentosRepository) {
    this.lancamentosRepository = lancamentosRepository;
  }

  public Lancamento salvar(Lancamento lancamento) {
    Lancamento lancamentoEntity = lancamentosRepository.save(lancamento);

    Email email = Email.builder()
      .emailTo("alexmotadev@gmail.com")
      .emailFrom("alexmotadev@gmail.com")
      .subject("Alteração de lancamento")
      .text("Olá, sua despesa/receita foi atualizada")
      .build();

    rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.LANCAMENTO_CADASTRAR, email);
    return lancamentoEntity;
  }

  public List<Lancamento> consultar() {
    return lancamentosRepository.findAll();
  }

  public void deletar(Long code) {

    lancamentosRepository.deleteById(code);

    Email email = Email.builder()
      .emailTo("alexmotadev@gmail.com")
      .emailFrom("alexmotadev@gmail.com")
      .subject("Exclusão de algo")
      .text("Olá, sua despesa/receita foi excluida")
      .build();

    rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.LANCAMENTO_APAGAR, email);
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
