package capitulo5.cap5lab1;

public class Cap5_Lab1 {

    public static void main(String[] args) {

        //constutor padrão
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Alex");
        funcionario.setSobreNome("Mota");
        funcionario.setCargo("Analista de Sistema");
        funcionario.setSalario(1000.00);

        // contrutor construido
        Funcionario funcionario1 = new Funcionario("Alan", "Mota", "Analista Java", 1000.00);

        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Sobrenome: " + funcionario.getSobreNome());
        System.out.println("Cargo: " + funcionario.getCargo());
        System.out.println("Salario: " + funcionario.getSalario());

        System.out.println("***********************");

        System.out.println("Nome: " + funcionario1.getNome());
        System.out.println("Sobrenome: " + funcionario1.getSobreNome());
        System.out.println("Cargo: " + funcionario1.getCargo());
        System.out.println("Salario: " + funcionario1.getSalario());

    }
}
