package com.refactorizando.example.user.mockresttemplate.config;


import com.refactorizando.example.user.mockresttemplate.entity.AccountEntity;
import com.refactorizando.example.user.mockresttemplate.repository.AccountRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Data {

  @Autowired
  AccountRepository accountRepository;

  @EventListener
  public void appReady(ApplicationReadyEvent event) {
    accountRepository.save(
        new AccountEntity(UUID.randomUUID(), "0060a6e2-f47e-42b5-8cb3-a45932920204", LocalDate.MAX, new BigDecimal(1.5), "0060a6e2-f47e-42b5-8cb3-a45932920204"));
  }
}

