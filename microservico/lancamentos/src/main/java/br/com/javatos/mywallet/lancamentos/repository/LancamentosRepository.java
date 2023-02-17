package br.com.javatos.mywallet.lancamentos.repository;

import br.com.javatos.mywallet.lancamentos.model.Lancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface LancamentosRepository extends JpaRepository<Lancamento, Long> {

  List<Lancamento> findByCode(Long code);

  // where descricao like '%descricao%' and dataInicial > '2023-02-14' and dataFinal < '2023-02-14';
  Page<Lancamento> findByDescricaoContainingIgnoreCaseAndDataDaCompraAfterAndDataDeVencimentoBefore(String descricao, LocalDate inicio, LocalDate fim, Pageable pageable);

//  exemplos
//  List<Lancamento> findByTipo(String tipo);
//
//  List<Lancamento> findByValorIsGreaterThanEqual(BigDecimal valor);
//  List<Lancamento> findByDescricaoContainingIgnoreCaseAndBetween(String descricao, LocalDate inicio, LocalDate fim);
//  @Query("SELECT l FROM Lancamento l where l.valor >?")
//  List<Lancamento> buscaPorValor(BigDecimal valor);
}
