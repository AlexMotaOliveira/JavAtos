package br.com.javatos.mywallet.email.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

  public static final String CRIAR = "criar";
  public static final String ALTERAR = "alterar";
  public static final String LANCAMENTO = "lancamento";
  public static final String EXCLUIR = "excluir";

  @Bean
  public MessageConverter messageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public Queue queueCriar(){
    return new Queue(CRIAR,true);
  }

  @Bean
  public Queue queueAlterar(){
    return new Queue(ALTERAR,true);
  }

  @Bean
  public Queue queueExcluir(){
    return new Queue(EXCLUIR,true);
  }

  @Bean
  public DirectExchange directExchange(){
    return new DirectExchange(LANCAMENTO);
  }


  @Bean
  public Binding bindingCriar(){
    return BindingBuilder.bind(queueCriar()).to(directExchange()).withQueueName();
  }

  @Bean
  public Binding bindingAlterar(){
    return BindingBuilder.bind(queueAlterar()).to(directExchange()).withQueueName();
  }

  @Bean
  public Binding bindingExcluir(){
    return BindingBuilder.bind(queueExcluir()).to(directExchange()).withQueueName();
  }

}
