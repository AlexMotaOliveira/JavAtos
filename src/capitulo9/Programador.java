package capitulo9;

// subclasse de Pessoa, e Pessoa é a SuperClasse
public class Programador extends Pessoa {

    private String linguagem;


    public Programador(String nome, String sobreNome, String email, String cpf, String linguagem) {
        super(nome, sobreNome, email, cpf);
        this.linguagem = linguagem;
    }

    public Programador(){}

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }


    @Override
    public final void setNome(String nome) {
        this.nome = nome.toLowerCase();
    }


    public void setNome(int nome) {

    }

    @Override
    public String toString() {
        return "Programador{" +
                "linguagem='" + linguagem + '\'' +
                ", nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

    @Override
    protected String getNomeComSobrenome() {
        return super.getNomeComSobrenome();
    }
}
