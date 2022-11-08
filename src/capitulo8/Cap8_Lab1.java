package capitulo8;

public class Cap8_Lab1 {

    public static void main(String[] args) {

        int maiorNumero = maiorNumero(args);

        for (String cadaNumero : args) {
            System.out.print(cadaNumero + " ");
        }
        System.out.println("O maior numero é: " + maiorNumero);
    }
    public static int maiorNumero(String[] listanumeros) {
        //TODO implementar a logica para achar o maior numero
        int maior = 0;
        for (String numeroString : listanumeros) {
            int numero = Integer.parseInt(numeroString);
            if (numero > maior) {
                maior = numero;
            }
        }
        return maior;
    }
}
