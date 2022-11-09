package capitulo10;

public interface Somar {

    public abstract int somar(int valor1, int valor2);

    // implicito public abstract
    double somar(double valor1, double valor2);

    default double somar(double valor1, float valor2) {
        return somar((float) valor1, valor2);
    }

    default double somar(long valor1, float valor2) {
        return somar((float) valor1, valor2);
    }

    static double somar(float valor1, long valor2) {
        return valor1 + valor2;
    }

    private double somar(float valor1, float valor2) {
        return valor1 + valor2;
    }
}
