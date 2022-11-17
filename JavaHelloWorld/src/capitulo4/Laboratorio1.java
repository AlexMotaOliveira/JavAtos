package capitulo4;

public class Laboratorio1 {

    public static void main(String[] args) {

        int numero = 1;
        int divisores = 0;

        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                divisores++;
//                System.out.println(i);
            }
        }

        if (divisores > 2) {
            System.out.println(numero + " não é um numero primo");
        } else {
            System.out.println(numero + " é um numero primo");
        }
//        System.out.println("quantidade de divisores: " + divisores);

        System.out.println(numero + (divisores == 2 ? " é numero Primo" : " não é numero Primo"));

    }
}
