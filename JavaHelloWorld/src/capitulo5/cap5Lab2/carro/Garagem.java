package capitulo5.cap5Lab2.carro;

public class Garagem {

    private Carro carroPasseio;
    private Carro carroUtilitario;

    public Garagem(){

    }
    public Garagem(Carro carroPasseio, Carro carroUtilitario) {
        this.carroPasseio = carroPasseio;
        this.carroUtilitario = carroUtilitario;
    }

    public Carro getCarroPasseio() {
        return carroPasseio;
    }

    public void setCarroPasseio(Carro carroPasseio) {
        this.carroPasseio = carroPasseio;
    }

    public Carro getCarroUtilitario() {
        return carroUtilitario;
    }

    public void setCarroUtilitario(Carro carroUtilitario) {
        this.carroUtilitario = carroUtilitario;
    }
}
