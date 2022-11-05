package capitulo6.cap6lab1;

public class Cap6_Lab3 {


    public static void main(String[] args) {

        Aluno joao = new Aluno("João");
        joao.imprimir();
        Aluno maria = new Aluno("Maria");
        maria.imprimir();
        Aluno marcos = new Aluno("Marcos");
        marcos.imprimir();
        System.out.println("total de aluanos: " + Aluno.contadorDeAlunos);

        System.out.println("-----------------------------");

    }
}
