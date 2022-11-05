package capitulo8;

import capitulo6.cap6lab1.Aluno;

public class Arrays_Lista {

    public static void main(String[] args) {
                     //0,1,2,3,4,5,6
        int[] lista = {1,2,3,4,5,6,7}; // lista com as 7 posições e 7 elementos
        int[] lista1 = new int [6];   // lista com as 5 posições vazias de 0 a 4
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
//        System.out.println(lista1[0]);
//        System.out.println(lista1[1]);
//        System.out.println(lista1[2]);
//        System.out.println(lista1[3]);
//        System.out.println(lista1[4]);
//        System.out.println(lista1[5]);

//        for (int cadaItemLista: lista1) {
//           cadaItemLista  *= 10;
//        }

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

        for (Aluno cadaAlunoNaLIsta: listaAlunos) {
            cadaAlunoNaLIsta.imprimir();
        }
    }
}
