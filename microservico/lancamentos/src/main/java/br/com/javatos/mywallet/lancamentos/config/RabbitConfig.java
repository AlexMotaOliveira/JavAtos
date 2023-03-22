package br.com.javatos.mywallet.lancamentos.config;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

  public static final String EXCHANGE = "lancamento";
  public static final String LANCAMENTO_CADASTRAR = "lancamento.cadastrar";
  public static final String LANCAMENTO_APAGAR = "lancamento.apagar";

  @Bean
  public MessageConverter messageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public DirectExchange directExchange() {
    return new DirectExchange(EXCHANGE);
  }

  @Bean
  public Queue queue() {
    return new Queue(LANCAMENTO_CADASTRAR, true);
  }


  @Bean
  public Queue queue1() {
    return new Queue(LANCAMENTO_APAGAR, true);
  }



}
