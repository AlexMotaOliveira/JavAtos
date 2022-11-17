package capitulo11;

import capitulo6.cap6lab1.Aluno;

import java.io.FileReader;
import java.io.IOException;

public class TryCatch {


    public static void main(String[] args) {
        //0  1 2  3  4
        int[] listaNumeros = new int[]{1, 2, 3, 4, 5};

        try {
//            listaNumeros[6] = 23;
//            Integer.parseInt("Alex");
            somar(10);

            Aluno aluno = null;
            System.out.println(aluno.getNome());

            FileReader fileReader = new FileReader("");


        } catch (NumberFormatException erro) {
            System.out.println("capturei o erro: " + erro);
        } catch (ArrayIndexOutOfBoundsException erro) {
            System.out.println("posição invalida array: " + erro);
        } catch (IOException erro) {
            System.out.println("erros: " + erro);
        }catch (ConverterException e){
            System.out.println("erros: " + e);
//        } catch (Exception exception) {
//            System.out.println("erros: " + exception);
        } finally {
            System.out.println("Ola ");
        }

//        System.out.println(listaNumeros[6]);
//
//        for (int i = 0; true; i++) {
//            System.out.println(i);
//        }
    }

    /**
     * @param valor1 um numero qualquer
     * @return valor inteiro que representa algo
     * @throws ConverterException
     * @see Aluno
     */
    public static int somar(int valor1) throws ConverterException {
        System.out.println("erros checados");
        return 0;
    }
}
