package capitulo9.laboratorio;

public class RG {

    private int numero;
    private String dataDeNascimento;

    public RG(int numero, String dataDeNascimento) {
        this.numero = numero;
        this.dataDeNascimento = dataDeNascimento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}
