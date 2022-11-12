package capitulo19.exemplo;

import java.util.List;

public interface Conexao {

    void salvar(Aluno aluno);
    void salvarTodos(List<Aluno> alunos);
    void buscarTodos();
    void buscar();
    void apagar();

}
