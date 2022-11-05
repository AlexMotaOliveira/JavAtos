package capitulo6.cap6lab1;

public class Aluno {

    public static int contadorDeAlunos;
    private String nome;

    public Aluno(){

    }
    public Aluno(String nome) {
        this.nome = nome;
        contadorDeAlunos++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void imprimir(){
        System.out.println("Aluno: " + nome);
        System.out.println(contadorDeAlunos);
    }
}
