package capitulo14;

import java.util.Arrays;

public class TesteFuncional {


    public static void main(String[] args) {

        OperacaoAritimetica operacaoAritimetica = new Calculadora();

        double valor = operacaoAritimetica.execute(10, 10, 3);
        System.out.println(valor);

        OperacaoAritimetica funcional = (x, y, z) -> x * y * x;
        double resultado = funcional.execute(12.2, 658, 23);
        System.out.println(resultado);

        OperacaoAritimetica funcional2 = (x, y, z) -> x * y * y;
        double resultado2 = funcional.execute(12.2, 658, 23);
        System.out.println(resultado);

        Arrays.asList(1,2,3,4,5).stream().filter(integer -> integer > 10);


    }


}
