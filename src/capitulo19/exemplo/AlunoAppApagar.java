package capitulo19.exemplo;

import java.sql.SQLException;
import java.util.Scanner;

public class AlunoAppApagar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*** excluir um aluno ***");
        System.out.println("Digite o seu cpf: ");
        String cpf = scanner.nextLine();

        try {
            ConexaoImplementacaoAluno conexaoImplementacaoAluno = new ConexaoImplementacaoAluno();
            conexaoImplementacaoAluno.apagar(cpf);
        } catch (SQLException e) {

        }
    }
}
