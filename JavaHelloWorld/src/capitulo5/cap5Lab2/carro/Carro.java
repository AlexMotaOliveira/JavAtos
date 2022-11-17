package capitulo5.cap5Lab2.carro;

public class Carro {

    private String modelo;
    private int potenciaDoMotor;
    private String cor;

    public Carro(){

    }


    public Carro(String modelo, int potenciaDoMotor, String cor) {
        this.modelo = modelo;
        this.potenciaDoMotor = potenciaDoMotor;
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPotenciaDoMotor() {
        return potenciaDoMotor;
    }

    public void setPotenciaDoMotor(int potenciaDoMotor) {
        this.potenciaDoMotor = potenciaDoMotor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void imprimir(){
        System.out.println("modelo: " + modelo );
        System.out.println("Potencia do motor: " + potenciaDoMotor );
        System.out.println("cor: " + cor );
    }
}
