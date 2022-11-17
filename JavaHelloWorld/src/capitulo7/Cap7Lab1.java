package capitulo7;

public class Cap7Lab1 {

    public static void main(String[] args) {

        Cadastro cadastro1 = new Cadastro();
        Cadastro cadastro2 = new Cadastro("Alex", "Mota");
        Cadastro cadastro3 = new Cadastro("Maria", "Mota", 15);

        System.out.println(cadastro1);
        cadastro1.mostrar();
        System.out.println("***************");
        cadastro2.mostrar();
        System.out.println("***************");
        cadastro3.mostrar();

        System.out.println("***************");
        System.out.println(cadastro1);
        cadastro1.setNome("João");
        cadastro1.setSobrenome("Silva");
        cadastro1.setIdade(50);

        cadastro1.mostrar();
        System.out.println("***************");
        System.out.println(cadastro1.getNome());
        System.out.println(cadastro1.getSobrenome());
        System.out.println(cadastro1.getIdade());

    }
}
