package com.refactorizando.example.user.mockresttemplate.controller;


import com.refactorizando.example.user.mockresttemplate.domain.Account;
import com.refactorizando.example.user.mockresttemplate.domain.User;
import com.refactorizando.example.user.mockresttemplate.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

  private final UserService userService;


  @GetMapping("/users/{accountNumber}")
  public ResponseEntity<User> getUserByAccountNumber(@PathVariable(name = "accountNumber")
      String accountNumber) {

    return ResponseEntity.ok(
        userService.getUserByAccountNumber(accountNumber));

  }
}
