package capitulo19.br.com.impacta.java.dao;

import capitulo19.br.com.impacta.java.model.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    private String url = "jdbc:mysql://localhost:3306/javatos";
    private String usuario = "root";
    private String senha = "123456"; // senha de VOCESSSS


    public void persist(Funcionario funcionario) throws DAOException {
        String query = "INSERT INTO funcionario (id, nome, salario, cargoId) VALUES (?, ?, ?,?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setNull(1, Types.INTEGER);
            preparedStatement.setString(2, funcionario.getNome());
            preparedStatement.setDouble(3, funcionario.getSalario());
            preparedStatement.setDouble(4, funcionario.getCargoId());

            int quantidade = preparedStatement.executeUpdate();
            System.out.println("Funcionario salvo: " + quantidade);

        } catch (SQLException e) {
            throw new DAOException("Falha ao salvar dados do funcionário" + e);
        } finally {
            closeResources(connection, preparedStatement, null);
        }
    }

    public List<Funcionario> findByName(String nome) throws DAOException {
        String query = "SELECT * FROM funcionario WHERE nome LIKE ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + nome + "%");
            resultSet = preparedStatement.executeQuery();

            List<Funcionario> funcionarioList = new ArrayList<>();
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(resultSet.getInt("id"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setSalario(resultSet.getDouble("salario"));
                funcionario.setCargoId(resultSet.getInt("cargoId"));

                funcionarioList.add(funcionario);
            }

            return funcionarioList;
        } catch (SQLException e) {
            throw new DAOException("Falha ao realizar consulta" + e);
        } finally {
            closeResources(connection, preparedStatement, resultSet);
        }
    }


    private Connection getConnection() throws DAOException {
        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    private void closeResources(Connection cn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
