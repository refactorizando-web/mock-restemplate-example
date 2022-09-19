package com.refactorizando.example.user.mockresttemplate.controller;


import com.refactorizando.example.user.mockresttemplate.domain.Account;
import com.refactorizando.example.user.mockresttemplate.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AccountController {

  private final AccountService accountService;

  @GetMapping("/accounts/{accountNumber}")
  public ResponseEntity<Account> getAccountByAccountNumber(@PathVariable(name = "accountNumber")
      String accountNumber) {

    return ResponseEntity.ok(
        accountService.getAccountByAccountNumber(accountNumber));

  }
}
