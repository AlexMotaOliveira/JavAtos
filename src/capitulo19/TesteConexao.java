package capitulo19;

import capitulo15.laboratorio.Estudante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TesteConexao {

    public static void main(String[] args) throws SQLException {

        Connection conexao = null;
        Statement statement = null;

        try {

            String url = "jdbc:mysql://localhost:3306/javatos";
            String usuario = "root";
            String senha = "123456"; // senha de VOCESSSS

            conexao = DriverManager.getConnection(url, usuario, senha);
            statement = conexao.createStatement();

            String selectQuery = "select * from javatos.aluno"; //
            boolean retorno = statement.execute(selectQuery);
            System.out.println(retorno);

            int integer = Types.INTEGER;
            int notaMatematica = 3;
            int notaPortugues = 4;
            String nome = "Jose Silva";
            String cpf = "23658954587";

            // ID   nome   NotaM  NotaP    CPF
            String insertQuery =
                    "INSERT INTO javatos.aluno VALUES (null," + nome + ", " + notaMatematica + ", " + notaPortugues + "," + cpf + ");";

//            int inteiro = statement.executeUpdate(insertQuery);
//            System.out.println(inteiro);
            //1,2,3,4,5
            String insertPreQuery = "INSERT INTO javatos.aluno VALUES (?,?,?,?,?);";
            PreparedStatement preparedStatement = conexao.prepareStatement(insertPreQuery);

            preparedStatement.setNull(1, integer);
            preparedStatement.setString(2, nome);
            preparedStatement.setDouble(3, notaMatematica);
            preparedStatement.setDouble(4, notaPortugues);
            preparedStatement.setString(5, cpf);

//            System.out.println(preparedStatement.executeUpdate());

            String selectResultQuery = "SELECT * FROM javatos.aluno order by id asc;"; //

            ResultSet resultSet = statement.executeQuery(selectResultQuery);

            List<Estudante> estudantes = new ArrayList<>();

            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt("id"));
                System.out.println("nome: " + resultSet.getString("nome"));
                System.out.println("nota_matematica: " + resultSet.getDouble("nota_matematica"));
                System.out.println("nota_portugues: " + resultSet.getInt("nota_portugues"));
                System.out.println("cpf: " + resultSet.getString("cpf"));
//
//                System.out.println("*************************************************************");

                Estudante estudante = new Estudante();
                estudante.setId(resultSet.getInt("id"));
                estudante.setNome(resultSet.getString("nome"));
                estudante.setNotaMatematica(resultSet.getDouble("nota_matematica"));
                estudante.setNotaPortugues(resultSet.getDouble("nota_portugues"));
                estudante.setCpf(resultSet.getString("cpf"));

                double media = (estudante.getNotaMatematica() + estudante.getNotaPortugues()) / 2;
                estudante.setMedia(media);
                estudantes.add(estudante);

            }

//            estudantes.forEach(estudante -> System.out.println(estudante));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            statement.close();
            conexao.close();
        }
    }
}