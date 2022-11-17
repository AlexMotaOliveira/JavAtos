package capitulo6;

import capitulo7.Cadastro;

public class UsaCalculadora {

    public static void main(String[] args) {

        int valor1 = 10;
        int valor2 = 20;

        Calculadora calculadora = new Calculadora();
        System.out.println("Valor da soma: " + calculadora.somar(valor1, valor2));
        System.out.println("valor1: " + valor1 + "-- valor2: " + valor2);
        System.out.println("---------------------");

        int resultado = calculadora.somar(Calculadora.VALOR_30, 30, 60);
        System.out.println("Valor da soma: " + resultado);

        double resultadoDouble = calculadora.somar(20.5, 30, 60);
        System.out.println("Valor da soma: " + resultadoDouble);

        System.out.println("-----------------------");

        Cadastro cadastro = new Cadastro("Alex", "Mota", 30);

        cadastro.mostrar();
        int resultadoDaIdadeEmDobro = Calculadora.dobrarIdade(cadastro);
        System.out.println("resultado da idade: " + resultadoDaIdadeEmDobro);
        System.out.println("----------------------- após o metodo");
        cadastro.mostrar();


        System.out.println(calculadora.somar(10, 30, 40, 56, 96, 69, 656658, 21548, 54, 0, 36, 99, 5, 20));

        System.out.println("--------------------");
        System.out.println(Calculadora.VALOR_30);

    }
}
