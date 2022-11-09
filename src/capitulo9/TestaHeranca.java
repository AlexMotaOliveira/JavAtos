package capitulo9;

public class TestaHeranca {

    public static void main(String[] args) {

//        Pessoa programador =
//        new Programador("Alex", "Mota","alex@ale.com", "123123123-96", "Java");
//
//        System.out.println(programador);
//
//        programador.nome = "Alex";
//        programador.setNome("João");
//        programador.getNome();
//
//        System.out.println(programador);
//
//        programador.sobreNome = "Mota";
//        programador.setSobreNome("Mota");
//        programador.getSobreNome();
//
//        programador.getEmail();
//        programador.setEmail("");
//
//        programador.cpf = "23123132123132";
//        programador.setCpf("23123132123132");
//        programador.getCpf();
//
//
//        Pessoa gerente = new Gerente();
//        gerente.getNome();
//
//        Pessoa pessoa = new Pessoa();
//        pessoa.setNome("Nome em maiusculo");
//
//        System.out.println(pessoa);
//
//        pessoa.getNomeComSobrenome();
//
//        Analista analista = new Analista();

        Quadrado quadrado = new Quadrado(10.2);
        double resultadoMetodoAbstratoQuadrado = quadrado.calcularArea();
        System.out.println("Metodo abstrato quadrado: " + resultadoMetodoAbstratoQuadrado);
        quadrado.calcularArea(10, 10);


        Triangulo triangulo = new Triangulo(10.0 , 5.9);
        double resultadoMetodoAbstratoTriangulo = triangulo.calcularArea();
        System.out.println("Metodo abstrato triangulo : " + resultadoMetodoAbstratoTriangulo);
    }

}
