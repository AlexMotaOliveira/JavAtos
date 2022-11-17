package capitulo9.laboratorio;

public class Professor extends Pessoa {
    private float salario;
    private String disciplina;

    public Professor(String nome, int idade, char sexo, int numeroRG, String dataNasc, float salario, String disciplina){
        super(nome, idade, sexo, new RG(numeroRG, dataNasc));
        this.salario = salario;
        this.disciplina = disciplina;
    }

    public Professor(String nome, int idade, char sexo, RG rg, float salario, String disciplina) {
        super(nome, idade, sexo, rg);
        this.salario = salario;
        this.disciplina = disciplina;
    }

    @Override
    public void falar(String fala){
        System.out.println(getNome() + ": " + fala);
    }

    @Override
    public void mostrarDados(){
        System.out.println();
        System.out.println("--- Professor: " + getNome() + " ---");
        System.out.println("Idade: " + getIdade());
        System.out.println("Sexo: " + getSexo());
        System.out.println("Salário: " + getSalario());
        System.out.println("Disciplina: " + getDisciplina());
        System.out.println("Número RG: " + getRg().getNumero());
        System.out.println("Data de Nascimento: " + getRg().getDataDeNascimento());
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
