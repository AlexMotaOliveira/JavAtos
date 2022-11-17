package capitulo6;

import capitulo7.Cadastro;

public class Calculadora {

    public static int VALOR_30 = 30;

    public int somar(int valor1, int valor2){
        int resultado = valor1 + valor2;
        valor1 = 10_000;
        valor2 = 50;
        return resultado;
    }

    public int somar(int valor1, int valor2, int valor3){
        int resultado = valor1 + valor2 + valor3;
        return resultado;
    }

    public double somar(double valor1, int valor2, int valor3){
        double resultado = valor1 + valor2 + valor3;
        return resultado;
    }

    public int somar(int...  lista){
        int resultado = 0;
//        for (int i = 0; i < lista.length; i++) {
//            resultado += lista[i];
//        }

        for (int valor: lista) {
            resultado += valor;
            System.out.println(valor);
        }
        return resultado;
    }

    public static int dobrarIdade(Cadastro cadastro){
        int resultado = cadastro.getIdade() * 2;
        cadastro.setSobrenome("Silva");
        cadastro.setIdade(resultado);
        return resultado;
    }

}
