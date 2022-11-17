package capitulo19.br.com.impacta.java;

import capitulo10.Somar;
import capitulo19.br.com.impacta.java.dao.DAOException;
import capitulo19.br.com.impacta.java.dao.FuncionarioDAO;
import capitulo19.br.com.impacta.java.model.Funcionario;

import java.util.List;
import java.util.Scanner;

public class LocalizaCadastro {

    public static void main(String[] args) {

        FuncionarioDAO dao = new FuncionarioDAO();
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Nome      : ");
            String nome = scanner.nextLine();

           List<Funcionario> funcionarioList =  dao.findByName(nome);
           funcionarioList.forEach(funcionario -> System.out.println(funcionario));



        } catch (DAOException e) {
            System.out.println("Falha ao salvar dados do funcionário.");
        } finally {
            scanner.close();
        }
    }
}
