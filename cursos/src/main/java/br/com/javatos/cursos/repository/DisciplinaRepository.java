package br.com.javatos.cursos.repository;

import br.com.javatos.cursos.model.Aluno;
import br.com.javatos.cursos.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina,Long> {
}
