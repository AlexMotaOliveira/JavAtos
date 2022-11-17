package capitulo12;

import capitulo10.Calculadora;

import capitulo6.cap6lab1.Aluno;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;


public class Testes {

    @Test
    public void MeuPrimeiroTeste() {

        Calculadora calculadora = new Calculadora();
        int resutadoDaSoma = calculadora.somar(10, 10);
        System.out.println("Resultado: " + resutadoDaSoma);
        Assertions.assertEquals(20, resutadoDaSoma);
        Assertions.assertNotEquals(10, resutadoDaSoma);

        boolean validacao = resutadoDaSoma == 20 ? true : false;
        Assertions.assertTrue(validacao);
        Assertions.assertFalse(!validacao);

    }

    @Test
    public void testeClasseAlunoNotNull() {

        Aluno aluno = null;
        Assertions.assertNull(aluno);
        aluno = new Aluno();
        Assertions.assertNotNull(aluno);
        fail();
    }
}
