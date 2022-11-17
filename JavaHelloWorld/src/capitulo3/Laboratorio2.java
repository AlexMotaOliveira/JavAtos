package capitulo3;

public class Laboratorio2 {

    public static void main(String[] args) {
        double valor = 0;
        valor = 1;
        valor %= 2;
        String ternario = valor == 0 ? "Par" : "Impar";
        System.out.println(ternario);
//        System.out.printf(" %.2f%n", valor);
    }
}
