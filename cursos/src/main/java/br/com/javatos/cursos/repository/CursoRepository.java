package br.com.javatos.cursos.repository;

import br.com.javatos.cursos.model.Aluno;
import br.com.javatos.cursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Long> {
}
