package capitulo19.exemplo;

import java.sql.SQLException;
import java.util.List;

public interface Conexao {

    void salvar(Aluno aluno) throws SQLException;
    void salvarTodos(List<Aluno> alunos);
    void buscarTodos();
    void buscar(String cpf);
    void apagar(String cpf);

    void atualizar(Aluno aluno);



}
