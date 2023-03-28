package br.com.javatos.mywallet.email.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableScheduling
public class Teste {

  @Scheduled(fixedDelay = 100)
  public void scheduleFixedDelayTask() {
    log.info("Fixed delay task - " + System.currentTimeMillis() / 1000);
  }
}
