package capitulo19.exemplo;

import java.sql.*;
import java.util.List;

public class ConexaoImplementacaoAluno extends ConexaoMysql implements Conexao {

    private Connection conexao = getConexao();
    private Statement statement = getConexao().createStatement();
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ConexaoImplementacaoAluno() throws SQLException {
    }

    @Override
    public void salvar(Aluno aluno) throws SQLException {
        try {
            String insertPreQuery = "INSERT INTO javatos.aluno VALUES (?,?,?,?,?);";
            preparedStatement = conexao.prepareStatement(insertPreQuery);
            preparedStatement.setNull(1, Types.INTEGER);
            preparedStatement.setString(2, aluno.getNome());
            preparedStatement.setDouble(3, aluno.getNotaMatematica());
            preparedStatement.setDouble(4, aluno.getNotaPortugues());
            preparedStatement.setString(5, aluno.getCpf());

            int resultado = preparedStatement.executeUpdate();
            conexao.commit();
            System.out.println("quantidade de aluno inserido: " + resultado);
            preparedStatement.close();
        } catch (SQLException e) {
            conexao.rollback();
            System.out.println(e);
        }
    }

    @Override
    public void salvarTodos(List<Aluno> alunos)  {
        alunos.forEach(aluno -> {
            try {
                salvar(aluno);
            } catch (SQLException e) {
                System.out.println(e);
            }
        });
    }

    @Override
    public void buscarTodos() {
        try {
            String selectResultQuery = "SELECT * FROM javatos.aluno order by id";
            ResultSet resultSet = statement.executeQuery(selectResultQuery);
            while (resultSet.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(resultSet.getInt("id"));
                aluno.setCpf(resultSet.getString("cpf"));
                aluno.setNome(resultSet.getString("nome"));
                aluno.setNotaMatematica(resultSet.getDouble("nota_matematica"));
                aluno.setNotaPortugues(resultSet.getDouble("nota_portugues"));
                aluno.setMedia(aluno.getMedia());
                System.out.println(aluno);
            }
            conexao.commit();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void buscar(String cpf) {
        try {
            String selectResultQuery = "SELECT * FROM javatos.aluno where cpf = " + cpf; //
            ResultSet resultSet = statement.executeQuery(selectResultQuery);
            while (resultSet.next()) {
                Aluno aluno = new Aluno();
                aluno.setId(resultSet.getInt("id"));
                aluno.setCpf(resultSet.getString("cpf"));
                aluno.setNome(resultSet.getString("nome"));
                aluno.setNotaMatematica(resultSet.getDouble("nota_matematica"));
                aluno.setNotaPortugues(resultSet.getDouble("nota_portugues"));
                aluno.setMedia(aluno.getMedia());
                conexao.commit();
                System.out.println(aluno);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void apagar(String cpf) {
        try {
            String deleteQuery = "DELETE FROM javatos.aluno WHERE cpf = " + cpf;
            int quantidade = statement.executeUpdate(deleteQuery);
            conexao.commit();
            System.out.println("Aluno excluido: " + quantidade);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @Override
    public void atualizar(Aluno aluno) {
        try {
            String updateQuery = "UPDATE javatos.aluno SET nome = '" + aluno.getNome() +
                    "' WHERE cpf = '" + aluno.getCpf() + "';";
            int quantidade = statement.executeUpdate(updateQuery);
            conexao.commit();
            System.out.println("nome do Aluno alterado: " + quantidade);
//            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
