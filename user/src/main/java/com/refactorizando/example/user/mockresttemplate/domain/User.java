package com.refactorizando.example.user.mockresttemplate.domain;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private String userId;

  private String accountNumber;

  private String name;

  private String surname;

  private String address;

  private Account account;
}
