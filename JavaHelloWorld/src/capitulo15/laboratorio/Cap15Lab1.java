package capitulo15.laboratorio;

import java.util.HashMap;
import java.util.Map;

public class Cap15Lab1 {

    public static void main(String[] args) {

        Map<String, Integer> pessoaMap = new HashMap<>();

        pessoaMap.put("Alex", 36);
        pessoaMap.put("Jose", 15);
        pessoaMap.put("Flavia", 56);

        System.out.println("--Pessoa --");
        pessoaMap.forEach((nome, idade) -> System.out.printf("Nome: %s , idade %d \n", nome, idade));

        for (String nome :pessoaMap.keySet()) {
            System.out.println(nome + " " + pessoaMap.get(nome));
        }

        System.out.println("Alex " + pessoaMap.get("Alex"));
        System.out.println("Jose " + pessoaMap.get("Jose"));
        System.out.println("Flavia " + pessoaMap.get("Flavia"));
    }
}
