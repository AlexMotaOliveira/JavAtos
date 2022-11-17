package capitulo9;

public class ChatWhatsApp extends Chat{

    protected String rg;

    @Override
    protected String criarConversa() {
        return "Criando um chat ChatWhatsApp";
    }

    @Override
    protected String enviarMensagem() {
        return "Enviando uma msg via chat ChatWhatsApp";
    }

    @Override
    protected String receberMensagem() {
        return "Recebendo um mgs do ChatWhatsApp";
    }

    @Override
    protected String encerrarConversa() {
        return "encerrando a conversa no ChatWhatsApp";
    }

    public String getStatus(){
        return "Onilne";
    }

    public String digitar(){
        return "digitanto ...";
    }

    public String enviarImagem(){
        return "enviando uma imagem";
    }
}
