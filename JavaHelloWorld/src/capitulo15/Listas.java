package capitulo15;

import capitulo6.cap6lab1.Aluno;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        List<String> novalistaConFiltro = new ArrayList<>();
        for (String item : lista) {
            if (item.contains("novalista")) {
                novalistaConFiltro.add(item);
            }
        }

        List<String> outraLista = lista.stream()
                .filter(item ->
                        item.contains("item"))
                .collect(Collectors.toList());

        for (String item : novalistaConFiltro) {
            System.out.println(item);
        }

        lista.get(0);
        lista.contains("intem");

        lista.forEach(cadaItemDentroDoForEach -> System.out.println(cadaItemDentroDoForEach));

        lista.forEach(cadaItemDentroDoForEach -> {
            System.out.println(cadaItemDentroDoForEach);
            System.out.println(cadaItemDentroDoForEach);
            System.out.println(cadaItemDentroDoForEach);
            System.out.println(cadaItemDentroDoForEach);
        });


        lista.stream()
                .filter(item -> item.contains("item"))
                .forEach(s -> {
                    System.out.println("Item na nova lista gerada: " + s);
                    System.out.println(s.toUpperCase());
                });

        System.out.println();

        lista.stream()
                .sorted((o1, o2) -> o1.length())
                .sorted()
                .min((o1, o2) -> o1.length())
                .stream()
                .max((o1, o2) ->  o1.length())
                .stream()
                .reduce((s, s2) -> s + s);


        Map<Integer, String> map = new HashMap<>();

        map.put(126, "Alex Mota");
        map.put(125, "João");
        map.put(113, "Luana");
        map.put(113, "Alan");

        map.forEach((i, s) -> System.out.println("chave: " + i + "valor: " + s));
        map.get(123); // busca pela chave

        map.remove(125,"Luana");
        map.remove(123);



        int v = map.size();
        boolean f = map.containsKey(123);
        boolean m = map.containsValue("Jose");
        boolean k =  map.isEmpty();


        Map<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(126, "Alex Mota");
        treeMap.put(125, "João");
        treeMap.put(113, "Luana");
        treeMap.put(3, "Alan");

        System.out.println();

        Set<String> listaSet = new HashSet<>();
        listaSet.add("Alex");
        listaSet.add("Alex");
        listaSet.add("Alex");
        listaSet.add("Alex");
        listaSet.add("Alex");
        listaSet.add("Alex");

        listaSet.forEach(s -> System.out.println(s));

        List<List<List<String>>> lists = new ArrayList<>();
        int[][] list = new int[][]{};

    }
}
