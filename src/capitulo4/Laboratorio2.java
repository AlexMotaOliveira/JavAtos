package capitulo4;

public class Laboratorio2 {

    public static void main(String[] args) {

        String mes = "Fevereiro";

        switch (mes){
            case "Janeiro" :
            case "Marco" :
            case "Maio" :
            case "Agosto" :
            case "Julho" :
            case "Outubro" :
            case "Dezembro" :   System.out.println("O "+ mes + " escolhido tem 31 dias"); break;

            case "Abril" :
            case "Junho" :
            case "Setembro" :
            case "Novembro" :   System.out.println("O "+ mes + " escolhido tem 30 dias"); break;

            default:   System.out.println("O "+ mes + " escolhido tem 28 ou 29 dias"); break;
        }
    }

}
