package capitulo19.exemplo;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class ConexaoImplementacao implements Conexao {

    private String url = "jdbc:mysql://localhost:3306/javatos";
    private String usuario = "root";
    private String senha = "123456"; // senha de VOCESSSS
    private Connection conexao = getConexao();
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ConexaoImplementacao() throws SQLException {
    }

    @Override
    public void salvar(Aluno aluno) {
        try {
            String insertPreQuery = "INSERT INTO javatos.aluno VALUES (?,?,?,?,?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(insertPreQuery);
            preparedStatement.setNull(1, Types.INTEGER);
            preparedStatement.setString(2, aluno.getNome());
            preparedStatement.setDouble(3, aluno.getNotaMatematica());
            preparedStatement.setDouble(4, aluno.getNotaPortugues());
            preparedStatement.setString(5, aluno.getCpf());

            int resultado = preparedStatement.executeUpdate();
            System.out.println("quantidade de aluno inserido: " + resultado);
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void salvarTodos(List<Aluno> alunos) {
        alunos.forEach(aluno -> salvar(aluno));
    }

    @Override
    public void buscarTodos() {

    }

    @Override
    public void buscar() {

    }

    @Override
    public void apagar() {

    }

    private Connection getConexao() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }
}
