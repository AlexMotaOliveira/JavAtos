package capitulo15.laboratorio;

public class Estudante {

    private String nome;
    private double notaMatematica;
    private double notaPortugues;
    private double media;

    public Estudante(String nome, double notaMatematica, double notaPortugues) {
        this.nome = nome;
        this.notaMatematica = notaMatematica;
        this.notaPortugues = notaPortugues;
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
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
}
