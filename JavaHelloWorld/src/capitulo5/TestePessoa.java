package capitulo5;

public class TestePessoa {


    public static void main(String[] args) {

        int valor = 12;
        long valor2 = 12L;
        double double1 = 12.5;
        long valor3;
        valor3 = 23;

        String teste = "teste";

        Pessoa criarPessoa = new Pessoa(); // referencia Pessoa@707


//        criarPessoa.nome = "Alex";
        criarPessoa.setNome("Alex");
//        criarPessoa.idade = 36;
        criarPessoa.inserirIdade(36);
//        criarPessoa.cpf = "123123123-96";
        criarPessoa.setCpf("123123456-63");
//        criarPessoa.email = "alex@alex.com";
        criarPessoa.setEmail("alex@alex");

        System.out.println("referencia " + criarPessoa);
        System.out.println("nome " + criarPessoa.getNome());
        System.out.println("idade " + criarPessoa.pegarIdade());
//        System.out.println("cpf  " + criarPessoa.cpf);
        System.out.println("email " + criarPessoa.getEmail());

        criarPessoa.falar();

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        //tipo  nome   construtor
        Pessoa batata = new Pessoa();
        System.out.println("referencia " + batata);
        System.out.println("nome " + batata.getNome());
        System.out.println("idade " + batata.pegarIdade());
//        System.out.println("cpf  " + batata.cpf);
        System.out.println("email " + batata.getEmail());

        batata.falar();

        System.out.println("****************************");

        Pessoa tipoConstruido = new Pessoa("Alex", "senha nova");
        System.out.println("nome " + tipoConstruido.getNome());
        System.out.println("idade " + tipoConstruido.pegarIdade());
        System.out.println("cpf  " + tipoConstruido.getCpf());
        System.out.println("email " + tipoConstruido.getEmail());


        tipoConstruido.falar();
        tipoConstruido.setNome("Alan");

        System.out.println("nome " + tipoConstruido.getNome());

    }
}
