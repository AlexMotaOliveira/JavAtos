package capitulo11;

import capitulo6.cap6lab1.Aluno;

import java.util.Scanner;

public class TesteScanner {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int numero = scanner.nextInt();
        scanner.nextLine();
        String texto = scanner.nextLine();


        System.out.println(numero);
        System.out.println(texto);

        Aluno aluno= new Aluno();
        String nome = scanner.nextLine();

        aluno.setNome(nome);
        aluno.imprimir();

    }
}
