package capitulo15.laboratorio;

import java.util.ArrayList;
import java.util.List;

public class Cap15_Lab02 {

    public static void main(String[] args) {

        List<Estudante> estudantes = new ArrayList<>();
        estudantes.add(new Estudante("Joana", 8.5, 8.5));
        estudantes.add(new Estudante("Antônio", 6, 9));
        estudantes.add(new Estudante("Mariana", 7.5, 9));
        estudantes.add(new Estudante("Ricardo", 7, 6));
        estudantes.add(new Estudante("Gustavo", 9.5, 10));

        estudantes.forEach(estudante -> {
            double resultado = (estudante.getNotaMatematica() + estudante.getNotaPortugues()) / 2;
            estudante.setMedia(resultado);
        });

        System.out.println();
        estudantes.forEach(estudante -> {
            System.out.print("Nome: " + estudante.getNome());
            System.out.println("- Media: " + estudante.getMedia());
        });

    }
}
