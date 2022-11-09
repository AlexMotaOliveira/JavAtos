package capitulo10;

public class TesteInterface {

    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();
        System.out.println(calculadora.somar(10,30));
        System.out.println(calculadora.somar(10.3,30.3));
        System.out.println(calculadora.somar(10,30f));
        System.out.println(calculadora.somar(10.0,30f));

        System.out.println(calculadora.dividir(10,30));
        System.out.println(calculadora.dividir(20.6,30.4));

        System.out.println(Somar.somar(52f,36));

    }
}
