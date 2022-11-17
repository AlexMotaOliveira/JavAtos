package capitulo15;

import capitulo6.cap6lab1.Aluno;

import java.util.ArrayList;
import java.util.List;

public class TesteClasseGenerica {

    public static void main(String[] args) {

        List<Generica> listaGenerica = new ArrayList<>();
        int inteiro = 10;

        Generica generica = new Generica();
        listaGenerica.add(generica);
        System.out.println(generica);
        generica.setValue(10);
        listaGenerica.add(generica);
        System.out.println(generica);
        generica.setValue("Alex");
        listaGenerica.add(generica);
        System.out.println(generica);
        generica.setValue(20.30);
        listaGenerica.add(generica);
        System.out.println(generica);
        generica.setValue(new Aluno());
        listaGenerica.add(generica);
        System.out.println(generica);


    }
}
