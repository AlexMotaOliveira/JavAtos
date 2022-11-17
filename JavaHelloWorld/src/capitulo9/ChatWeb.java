package capitulo9;

public class ChatWeb extends Chat{

    protected String cpf;


    @Override
    protected String criarConversa() {
        return "Criando um chat Web";
    }

    @Override
    protected String enviarMensagem() {
        return "Enviando uma msg via chat Web";
    }

    @Override
    protected String receberMensagem() {
        return "Recebendo um mgs do chatWeb";
    }

    @Override
    protected String encerrarConversa() {
        return "encerrando a conversa no chatWeb";
    }
}
