package br.com.javatos.cursos.repository;

import br.com.javatos.cursos.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
}
