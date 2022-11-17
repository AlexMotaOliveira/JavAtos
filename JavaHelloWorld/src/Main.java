import capitulo2.DiaDaSemana;

public class Main {
    public static void main(String[] args) {

        // tipo variavel
        int inteiro = 10;
        long inteiro_Maior = 1_000_000;
        float decimal = 12.02f;
        double decimal2 = 12.30;
        char caracter1 = 'A'; // um caracter
        char caracter2 = 65; // um numero que representa um caracter
        boolean valida = true; // ou false

        //  true ou false
        if (inteiro == 10) {
            System.out.println("O Valor do inteiro é a 10");
        } else if (inteiro > 10) {
            int novaVariavel = 20;
        } else if (inteiro < 10) {
            int novaVariavel = 20;
            System.out.println(novaVariavel);
        } else {
            System.out.println("O Valor do inteiro não é igual a 10");
        }

        // uma condição que vai ser avaliada no CASE
        int condicao = 10;
        switch (condicao) {
            case 10:
                System.out.println("igual a 10");
                break;
            case 20: {
                System.out.println("igual a 20");
                break;
            }
            default:
                System.out.println("não é igual as outras condições");
        }

//        for (){}

        // true ou false
        int validador = 0;
        while (validador > 10) {
//            System.out.println("O Valor do inteiro não é igual a 10");
            validador++; //  validador = validador + 2;
        }

        String textoDentroDoFor = "O Valor do inteiro não é igual a 10";

//        for (Inicialização da variavel; condição  ; incremental)
        for (int i = 0; i < 10; i++) {
            System.out.println(textoDentroDoFor);
        }

        String texto = "consigo escrever varios caracteres";
        String segunda = "Segunda";
        String terca = "Terca";
        String quarta = "Quarta";

        //tipo enum
        DiaDaSemana diaHoje = DiaDaSemana.Domingo;

        // - + * / %
        int x1 = 1;
        x1 += 3; // x1 = x1 + 3;
        x1 -= 3; // x1 = x1 - 3;
        x1 *= 3; // x1 = x1 * 3;
        x1 /= 3; // x1 = x1 / 3;
        x1 %= 3; // x1 = x1 / 3;

        System.out.println(x1);

        String texto2 = "vou juntar um texto" + " texto ficou junto";

        System.out.println(texto2);

        // operadores relacionais
        boolean validacao = 10 > 10; // false
        boolean validacao1 = 10 < 10; // false
        boolean validacao2 = 10 == 10; // true
        boolean validacao3 = 10 >= 10; // true
        boolean validacao4 = 10 <= 10; // true
        boolean validacao5 = 10 != 10; // false

        // operadores logicos
        //true  E   true
        boolean validacao6 = 10 > 10 && 10 < 10;
        boolean validacao7 = 10 == 10 || 10 < 10;
        boolean validacao8 = 10 == 10 ^ 10 < 10;

        boolean verdadeiro = true;
        boolean falsa = !verdadeiro;
        boolean validacao10 = !(10 == 10) || 10 < 10;


        String ternario = 10 == 1 ? "valores são iguais" : "valores são diferentes";

        if (10 == 10) {
            String valor = "valores são iguais";
        } else {
            String valor = "valores são diferentes";
        }

    }
}