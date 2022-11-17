package capitulo9;

public class Quadrado extends Poligono{

    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public void calcularArea(int valor1, int valor2) {
        super.calcularArea(valor1, valor2);
    }
}
