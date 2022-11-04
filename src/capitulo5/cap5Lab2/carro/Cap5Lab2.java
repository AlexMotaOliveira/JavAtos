package capitulo5.cap5Lab2.carro;

public class Cap5Lab2 {

    public static void main(String[] args) {

        Garagem g = new Garagem();

        Carro carroPasseio = new Carro("Ford", 110, "vermelho");
        g.setCarroPasseio(carroPasseio);
        g.setCarroUtilitario(new Carro("Rand Rover",111,"azul"));

        g.getCarroPasseio().imprimir();

        System.out.println("-----------------------------");

        g.getCarroUtilitario().imprimir();
    }

}
