package capitulo9;

public class ChatAppMobile extends Chat{

    private String agencia;
    private String conta;

    @Override
    protected String criarConversa() {
        return "Criando um chat ChatAppMobile";
    }

    @Override
    protected String enviarMensagem() {
        return "Enviando uma msg via chat ChatAppMobile";
    }

    @Override
    protected String receberMensagem() {
        return "Recebendo um mgs do ChatAppMobile";
    }

    @Override
    protected String encerrarConversa() {
        return "encerrando a conversa no ChatAppMobile";
    }
}
