package capitulo15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

            String insertQuery = "INSERT INTO `javatos`.`aluno` VALUES (null,'Jose', '2', '3', '13654654654');";
            int inteiro = statement.executeUpdate(insertQuery);
            System.out.println(inteiro);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            statement.close();
            conexao.close();
        }
    }
}