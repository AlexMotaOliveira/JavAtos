package capitulo19.exemplo;

public class Aluno {

    private String nome;
    private double notaMatematica;
    private double notaPortugues;
    private double media;
    private String cpf;
    private int id;


    public Aluno() {

    }

    public Aluno(String nome, double notaMatematica, double notaPortugues, String cpf) {
        this.nome = nome;
        this.notaMatematica = notaMatematica;
        this.notaPortugues = notaPortugues;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNotaMatematica() {
        return notaMatematica;
    }

    public void setNotaMatematica(double notaMatematica) {
        this.notaMatematica = notaMatematica;
    }

    public double getNotaPortugues() {
        return notaPortugues;
    }

    public void setNotaPortugues(double notaPortugues) {
        this.notaPortugues = notaPortugues;
    }

    public double getMedia() {
        return (notaMatematica + notaPortugues) / 2;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", notaMatematica=" + notaMatematica +
                ", notaPortugues=" + notaPortugues +
                ", media=" + media +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
