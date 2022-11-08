package capitulo9;

public class TestaHeranca {

    public static void main(String[] args) {

        Pessoa programador =
        new Programador("Alex", "Mota","alex@ale.com", "123123123-96", "Java");

        System.out.println(programador);

        programador.nome = "Alex";
        programador.setNome("João");
        programador.getNome();

        System.out.println(programador);

        programador.sobreNome = "Mota";
        programador.setSobreNome("Mota");
        programador.getSobreNome();

        programador.getEmail();
        programador.setEmail("");

        programador.cpf = "23123132123132";
        programador.setCpf("23123132123132");
        programador.getCpf();


        Pessoa gerente = new Gerente();
        gerente.getNome();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Nome em maiusculo");

        System.out.println(pessoa);

    }

}
