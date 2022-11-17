package capitulo19.exemplo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class AlunoAppAtualizar {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("*** atualizar um aluno ***");

            System.out.println("Digite o cpf para atualizar o nome do aluno: ");
            String cpf = scanner.nextLine();

            System.out.println("Digite o novo nome do aluno: ");
            String nome = scanner.nextLine();



            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            aluno.setCpf(cpf);

            ConexaoImplementacaoAluno conexaoImplementacaoAluno = new ConexaoImplementacaoAluno();
            conexaoImplementacaoAluno.atualizar(aluno);


        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
