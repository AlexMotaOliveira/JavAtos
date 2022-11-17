package capitulo6.cap6lab1;

public class Cap6Lab1 {

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();

        System.out.println(calculadora.somar(10, 5));
        System.out.println(calculadora.subtrair(10, 5));
        System.out.println(calculadora.dividir(0, 5));
        System.out.println(calculadora.multiplicar(0, 0));

        System.out.println("------sobrecarga ________");
        System.out.println(calculadora.subtrair(11.0, 5.0));
        System.out.println(calculadora.subtrair(30.0, 5));
        System.out.println(calculadora.subtrair(60, 5.0));

    }
}
