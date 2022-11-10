package capitulo11.laboratorio;

import java.util.Scanner;

public class ExercicioIdade {

    // comentario em uma linha
    /*
    comentario com varias linhas seguidas
    comentario com varias linhas seguidas
    comentario com varias linhas seguidas
     */

    /**
     * @author Alex Mota
     * @param args varios argumentos que podem ser passados para executar o metodo main
     *
     *
     */
    public static void main(String[] args) {

        int resultado = 0;

        try {
            Scanner scanner = new Scanner(System.in);
            String texto = scanner.nextLine();
            int ano = Integer.parseInt(texto);
            resultado = 2022 - ano;
        } catch (NumberFormatException e) {
            System.out.println("Valor digitado inválido: " + e);
        }
        System.out.println("Idade: " + resultado);
    }
}
