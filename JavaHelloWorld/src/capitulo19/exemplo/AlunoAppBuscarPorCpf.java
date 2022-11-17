package capitulo19.exemplo;

import java.sql.SQLException;
import java.util.Scanner;

public class AlunoAppBuscarPorCpf {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o seu cpf: ");
        String cpf = scanner.nextLine();

        try {
            ConexaoImplementacaoAluno conexaoImplementacaoAluno = new ConexaoImplementacaoAluno();
            conexaoImplementacaoAluno.buscar(cpf);

            System.out.println("*********** bucar todos os alunos");
            conexaoImplementacaoAluno.buscarTodos();
        } catch (SQLException e) {

        }
    }
}
