package capitulo9;

public class Analista extends Programador{


    public Analista(String nome, String sobreNome, String email, String cpf, String linguagem) {
        super(nome, sobreNome, email, cpf, linguagem);
    }

    public Analista(){
        super();
    }

    @Override
    public void setNome(int nome) {
        //TODO fazer algo
    }
}
