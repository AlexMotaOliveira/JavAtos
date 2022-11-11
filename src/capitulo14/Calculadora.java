package capitulo14;

public class Calculadora implements OperacaoAritimetica {
    @Override
    public double execute(double valo1, double valor2, double v) {
        return valo1 + valor2;
    }
}
