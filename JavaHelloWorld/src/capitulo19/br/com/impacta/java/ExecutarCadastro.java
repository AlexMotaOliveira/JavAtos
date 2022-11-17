package capitulo19.br.com.impacta.java;

import capitulo19.br.com.impacta.java.dao.DAOException;
import capitulo19.br.com.impacta.java.dao.FuncionarioDAO;
import capitulo19.br.com.impacta.java.model.Funcionario;

import java.util.Scanner;

public class ExecutarCadastro {
    public static void main(String[] args) {

        FuncionarioDAO dao = new FuncionarioDAO();
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.print("Nome      : ");
            String nome = scanner.nextLine();

            System.out.print("Salario   : ");
            double salario = Double.parseDouble(scanner.nextLine());

            System.out.print("Cod. Cargo: ");
            int cargoId = Integer.parseInt(scanner.nextLine());

            Funcionario funcionario = new Funcionario();
            funcionario.setNome(nome);
            funcionario.setSalario(salario);
            funcionario.setCargoId(cargoId);

            dao.persist(funcionario);
            System.out.println("Funcionário cadastrado com sucesso.");

        } catch (NumberFormatException e) {
            System.out.println("Dados inválidos. Tente novamente.");
        } catch (DAOException e) {
            System.out.println("Falha ao salvar dados do funcionário.");
        } finally {
            scanner.close();
        }
    }
}
