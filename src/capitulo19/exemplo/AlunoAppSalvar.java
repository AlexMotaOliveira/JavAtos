package capitulo19.exemplo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlunoAppSalvar {

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("*** salvar um aluno ***");
            System.out.println("Digite o seu nome: ");
            String nome = scanner.nextLine();

            System.out.println("Digite o seu cpf: ");
            String cpf = scanner.nextLine();

            System.out.println("Digite a note de Matematica: ");
            double notaMatematica = scanner.nextDouble();

            System.out.println("Digite a note de Portugues: ");
            double notaPortugues = scanner.nextDouble();

            Aluno aluno = new Aluno(nome, notaMatematica, notaPortugues, cpf);

//            String nomeInput = JOptionPane.showInputDialog("Insira o seu nome: ");
//            String cpfInput = JOptionPane.showInputDialog("Insira o seu cpf: ");
//            String notaMatematicaInput = JOptionPane.showInputDialog("Insira a nota de matematica: ");
//            String notaPortuguesInput = JOptionPane.showInputDialog("Insira a nota de portugues: ");
//            double doublenotaMatematicaInput = Double.parseDouble(notaMatematicaInput);
//            double doublePortuguesInput = Double.parseDouble(notaPortuguesInput);

//            Aluno aluno2 = new Aluno(nomeInput, doublenotaMatematicaInput, doublePortuguesInput, cpfInput);

            Conexao conexao = new ConexaoImplementacaoAluno();
            List<Aluno> alunos = new ArrayList<>();
            alunos.add(aluno);
//            alunos.add(aluno2);

            conexao.salvarTodos(alunos);

//            conexao.salvar(aluno);
//            conexao.salvar(aluno2);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
