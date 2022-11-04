package capitulo5;

public class Pessoa {

    //atributo - molde ou modelo ou projeto
    // default
    private String nome; // null
    private int idade; // 0
    private String cpf; // null
    private String email; // null
    private String senha;


    //Construtor padrão
    public Pessoa() {

    }

    // tipo construido
    public Pessoa(String nome) {
        // this serve para apontar para o atributo da classe
        this.nome = nome;
        this.cpf = "123123132131-02";
    }

    public Pessoa(String nome, String senha) {
        // this serve para apontar para o atributo da classe
        this.nome = nome;
        this.senha = "123123132131-02";
    }

    // metodo é uma ação, é um verbo
    public void falar() {
        String falar = "Olá";
        System.out.println(falar);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int pegarIdade() {
        return idade;
    }

    public void inserirIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null) {
            this.email = email;
        }
        System.out.println("email não pode ser nulo");
    }
}
