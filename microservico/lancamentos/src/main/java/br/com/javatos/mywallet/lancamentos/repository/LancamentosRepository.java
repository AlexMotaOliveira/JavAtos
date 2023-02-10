package br.com.javatos.mywallet.lancamentos.repository;

import br.com.javatos.mywallet.lancamentos.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LancamentosRepository extends JpaRepository<Lancamento, Long> {

  List<Lancamento> findByCode(Long code);
}
