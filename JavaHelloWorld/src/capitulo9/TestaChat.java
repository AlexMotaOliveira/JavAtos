package capitulo9;

public class TestaChat {

    public static void main(String[] args) {


        ChatWeb chatWeb = new ChatWeb();
        System.out.println(chatWeb.criarConversa());
        System.out.println(chatWeb.enviarMensagem());
        System.out.println(chatWeb.receberMensagem());
        System.out.println(chatWeb.encerrarConversa());

        ChatAppMobile chatAppMobile = new ChatAppMobile();
        System.out.println(chatAppMobile.criarConversa());
        System.out.println(chatAppMobile.enviarMensagem());
        System.out.println(chatAppMobile.receberMensagem());
        System.out.println( chatAppMobile.encerrarConversa());

        ChatWhatsApp chatWhatsApp = new ChatWhatsApp();
        System.out.println(chatWhatsApp.criarConversa());
        System.out.println(chatWhatsApp.enviarMensagem());
        System.out.println(chatWhatsApp.digitar());
        System.out.println(chatWhatsApp.receberMensagem());
        System.out.println(chatWhatsApp.enviarImagem());
        System.out.println(chatWhatsApp.getStatus());
        System.out.println(chatWhatsApp.encerrarConversa());

    }
}
