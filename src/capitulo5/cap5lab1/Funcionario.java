package capitulo5.cap5lab1;

// classe de dominio ou classe modelo ou domaim ou model
public class Funcionario {

    private String nome;
    private String sobreNome;
    private String cargo;
    private double salario;

    public Funcionario(){

    }

    public Funcionario(String nome, String sobreNome, String cargo, double salario) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

}
