package capitulo4;

import capitulo5.Pessoa;

public class Laboratorio3_1 {

    public static void main(String[] args) {
        // 1930 + 4 = 1934
        for (long ano = 1930; ano <= 2022; ano += 4) {
            if (ano == 1942 || ano == 1946) {
                System.out.println("vai pular essa execução");
                continue;
            }
            System.out.println("Copa do mundo de " + ano + "!");
        }

        Pessoa pessoa = new Pessoa();
    }

}
