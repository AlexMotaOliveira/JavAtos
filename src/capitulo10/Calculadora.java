package capitulo10;

public class Calculadora implements Somar, Dividir {

    @Override
    public int somar(int valor1, int valor2) {
        return valor1 + valor2;
    }

    @Override
    public double somar(double valor1, double valor2) {
        return valor1 + valor2;
    }

    @Override
    public int dividir(int valor1, int valor2) {
        return valor1 / valor2;
    }

    @Override
    public double dividir(double valor1, double valor2) {
        return valor1 / valor2;
    }
}
