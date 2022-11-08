package capitulo2;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class ClasseWrapper {

    public static void main(String[] args) {

        int numeroInt = 27;
        String numeroTexto = "27" + "12";


        Integer integer = Integer.parseInt(numeroTexto);
        integer++;
        System.out.println(integer);

        String numerotoTexto = String.valueOf(integer);
        System.out.println(numerotoTexto);

        boolean validador = false; // true
        Boolean validadorWrapper = null;
        validadorWrapper.equals(validador);

        List<Integer> list = new ArrayList<>();

        if (numeroInt == 10){

        }

        if (integer.equals(10)){

        }

        byte bytte = 10;
        double doubble = bytte; // 1054564546545456454.30

        int inteiro = (int)doubble;  // 105456

    }
}
