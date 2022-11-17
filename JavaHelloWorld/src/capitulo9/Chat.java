package capitulo9;

public abstract class Chat {

    protected String nomeCliente;
    protected String nomeOperador;

    protected abstract String criarConversa();
    protected abstract String enviarMensagem();
    protected abstract String receberMensagem();
    protected abstract String encerrarConversa();

}
