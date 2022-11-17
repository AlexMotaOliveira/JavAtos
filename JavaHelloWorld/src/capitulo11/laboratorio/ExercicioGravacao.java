package capitulo11.laboratorio;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExercicioGravacao {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String texto = scanner.nextLine();

        PrintWriter writer;
        try {
            writer = new PrintWriter("C:\\doc1.txt");
            writer.println(texto);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Falha ao gravar as informações digitadas");
            System.out.println(e);
        }
    }
}
