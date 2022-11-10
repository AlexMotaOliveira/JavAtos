package capitulo15;

import capitulo6.cap6lab1.Aluno;

import java.util.ArrayList;
import java.util.List;

public class Listas {

    public static void main(String[] args) {

        int[] listaArray = new int[]{1, 2, 3, 6, 5, 8, 0, 0};
        listaArray[0] = 20;


        // crescente 10 ou 20 posições
        List<String> lista = new ArrayList<>();
        lista.add("primeiro item"); // FIFO
        int tamanhoLista = lista.size();
//        lista.clear();
//        lista.remove(0);
        boolean contem = lista.contains("primeiro item");
        lista.add(0, "");
        boolean isVazia = lista.isEmpty();

        for (int i = 0; i < 50; i++) {
            lista.add(i + "numero");
        }

        lista.remove(0); // 1 2 3
        for (String item : lista) {
            System.out.println(item.length());
        }

        lista.forEach(item -> System.out.println(item));
        lista.stream()
                .filter(item -> item.contains("item"))
                .forEach(s -> System.out.println("Item na nova lista gerada: " + s));

        System.out.println();

    }
}
