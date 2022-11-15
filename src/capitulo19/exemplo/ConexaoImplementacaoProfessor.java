//package capitulo19.exemplo;
//
//import java.sql.*;
//import java.util.List;
//
//public class ConexaoImplementacaoProfessor extends ConexaoMysql implements Conexao {
//
//    private Connection conexao = getConexao();
//    private Statement statement;
//    private PreparedStatement preparedStatement;
//    private ResultSet resultSet;
//
//    public ConexaoImplementacaoProfessor() throws SQLException {
//    }
//
//    @Override
//    public void salvar(Aluno aluno) {
//        try {
//            String insertPreQuery = "INSERT INTO javatos.aluno VALUES (?,?,?,?,?);";
//            preparedStatement = conexao.prepareStatement(insertPreQuery);
//            preparedStatement.setNull(1, Types.INTEGER);
//
//
//            int resultado = preparedStatement.executeUpdate();
//            System.out.println("quantidade de aluno inserido: " + resultado);
//            preparedStatement.close();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
//    @Override
//    public void salvarTodos(List<Aluno> alunos) {
//        alunos.forEach(aluno -> salvar(aluno));
//    }
//
//    @Override
//    public void buscarTodos() {
//
//    }
//
//    @Override
//    public void buscar() {
//
//    }
//
//    @Override
//    public void apagar() {
//
//    }
//}
