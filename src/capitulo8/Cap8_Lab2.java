package capitulo8;

public class Cap8_Lab2 {
    public static void main(String[] args) {
        if(args.length > 0){
            int soma = 0;
            for (int i = 0; i < args.length; i++) {
                soma += Integer.parseInt(args[i]);
            }
            int media = (soma / args.length);
            System.out.println("A média das idades é de: " + media);
        }
        else{
            System.out.println("Entre com valores válidos para as idades.");
        }
    }
}
