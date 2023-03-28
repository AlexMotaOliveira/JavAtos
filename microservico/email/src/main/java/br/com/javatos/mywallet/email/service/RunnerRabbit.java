package br.com.javatos.mywallet.email.service;

import org.springframework.stereotype.Component;

@Component
public class RunnerRabbit {

  public void run(Runnable runnable){
    runnable.run();
  }
}
