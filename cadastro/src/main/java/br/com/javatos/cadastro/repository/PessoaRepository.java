package br.com.javatos.cadastro.repository;

import br.com.javatos.cadastro.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findByCpf(String cpf);
    void deleteByCpf(String cpf);

    Optional<Pessoa> findByEmail(String email);

//    List<Pessoa> findByNomeContaining(String nome);  // LIKE %nome%

//    @Query("select * from pessoa where nome =?")
//    List<Pessoa> findByNome(String nome);  // LIKE %nome%

}
