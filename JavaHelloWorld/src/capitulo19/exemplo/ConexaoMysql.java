package capitulo19.exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMysql {

    private String url = "jdbc:mysql://localhost:3306/javatos";
    private String usuario = "root";
    private String senha = "123456"; // senha de VOCESSSS

    protected final Connection getConexao() throws SQLException {
        Connection connection = DriverManager.getConnection(url, usuario, senha);
        connection.setAutoCommit(false);
        return connection;
    }
}
