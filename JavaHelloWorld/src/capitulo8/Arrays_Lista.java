package capitulo8;

import capitulo6.cap6lab1.Aluno;

public class Arrays_Lista {

    public static void main(String[] args) {
                     //0,1,2,3,4,5,6
        int[] lista = {1,2,3,4,5,6,7}; // lista com as 7 posições e 7 elementos
        int[] lista1 = new int [6];   // lista com as 6 posições vazias de 0 a 5
        int[] lista2;                  // somente a referencia
        lista2 = new int[10];          // instanciando com 10 posições vazias
        int[] lista3;                  // somente a referencia
                         //0,1,2,3,4,5,6,7,8
        lista3 = new int[]{1,2,3,4,5,6,7,8,9};  // instanciando com 9 posições e 9 elementos


        lista1[0] = 20;
        lista1[1] = 20;
        lista1[2] = 20;
        lista1[3] = 20;
        lista1[4] = 20;
        lista1[5] = 20;
        System.out.println(lista1[0]);
        System.out.println(lista1[1]);
        System.out.println(lista1[2]);
        System.out.println(lista1[3]);
        System.out.println(lista1[4]);
        System.out.println(lista1[5]);

        for (int cadaItemLista: lista1) {
           cadaItemLista  *= 10;
        }

        for (int i = 0; i < lista1.length; i++) {
                    lista1[i] *= 10;
        }

        for (int cadaItemLista: lista1) {
            System.out.println(cadaItemLista);
        }

        Aluno alex = new Aluno("Alex");
        Aluno jao  = new Aluno("Jão");
        Aluno jose = new Aluno("Jose");
        Aluno[] listaAlunos = new Aluno[]{alex,jao,jose};

        for (Aluno cadaAlunoNaLIsta: listaAlunos) {
            cadaAlunoNaLIsta.setNome("Mota");
        }

        for (int i = 0; i < listaAlunos.length; i++) {
            System.out.println(listaAlunos[i]);
        }

        for (Aluno cadaAlunoNaLIsta: listaAlunos) {
            cadaAlunoNaLIsta.imprimir();
        }

        Aluno[][] listaDeAlunoBidimensional = new Aluno[3][3];

        listaDeAlunoBidimensional[0][0] = alex;
        listaDeAlunoBidimensional[0][1] = jao;
        listaDeAlunoBidimensional[0][2] = jose;

        listaDeAlunoBidimensional[1][0] = new Aluno("Alan");
        listaDeAlunoBidimensional[1][1] = new Aluno("Maria");
        listaDeAlunoBidimensional[1][2] = new Aluno("Rodrigo");

        listaDeAlunoBidimensional[2][0] = new Aluno("João");
        listaDeAlunoBidimensional[2][1] = new Aluno("Francisco");
        listaDeAlunoBidimensional[2][2] = new Aluno("Felipe");


        for (Aluno[] alunoLista: listaDeAlunoBidimensional) {
            System.out.println(alunoLista);
            for (Aluno aluno: alunoLista) {
                aluno.imprimir();
            }
        }

        Aluno[][][] listaDeAlunoMultidimensional = new Aluno[3][3][3];

        for (Aluno[][] alunoLista: listaDeAlunoMultidimensional) {
            System.out.println(alunoLista);
            for (Aluno[] alunoLista1: alunoLista) {
                for (Aluno aluno1:alunoLista1) {
                    System.out.println(aluno1);
                }
            }
        }
    }
}
