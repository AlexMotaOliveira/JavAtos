package capitulo9.laboratorio;

public class Cap9_Lab1 {

    public static void main(String[] args) {

        Pessoa aluno1 =
        new Aluno("Alex", 56, 'M', 123123, "05/02/1900", 1300.0f, "Java");

        Pessoa aluno2 =
        new Aluno("João", 30, 'M', 135156, "01/02/1900", 1300.0f, "Java WEB");

        Pessoa professor =
        new Professor("Davi", 60, 'M', 15646, "01/02/1800", 7000.0f, "Java WEB");

        aluno1.falar("Presente");
        aluno1.mostrarDados();

        aluno2.falar("Presente");
        aluno2.mostrarDados();

        professor.falar("Presente");
        professor.mostrarDados();


        Pessoa aluno3 =
        new Aluno("Alex", 56, 'M', new RG(123123, "05/02/1900"), 1300.0f, "Java");

        Pessoa professor2 =
        new Professor("Davi", 60, 'M', new RG(15646, "01/02/1800"), 7000.0f, "Java WEB");

    }
}
