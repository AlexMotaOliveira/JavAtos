package capitulo9;

public class Pessoa {

    public String nome;
    protected String sobreNome;
    private String email;
    String cpf;

    public Pessoa(String nome, String sobreNome, String email, String cpf) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.email = email;
        this.cpf = cpf;
    }

    public Pessoa(){

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobreNome='" + sobreNome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }


    protected String getNomeComSobrenome() {
        return nome.concat(" ").concat(sobreNome).concat(":");  // nome + sobreNome
    }


}
