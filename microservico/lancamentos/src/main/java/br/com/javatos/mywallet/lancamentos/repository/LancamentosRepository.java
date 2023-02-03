package br.com.javatos.mywallet.lancamentos.repository;

import br.com.javatos.mywallet.lancamentos.model.Lancamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentosRepository extends JpaRepository<Lancamentos, Long> {
}
