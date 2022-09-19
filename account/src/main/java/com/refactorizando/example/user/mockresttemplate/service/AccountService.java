package com.refactorizando.example.user.mockresttemplate.service;

import com.refactorizando.example.user.mockresttemplate.domain.Account;
import com.refactorizando.example.user.mockresttemplate.mapper.AccountMapper;
import com.refactorizando.example.user.mockresttemplate.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class AccountService {


  private final AccountRepository accountRepository;

  private final AccountMapper accountMapper;

  public Account getAccountByAccountNumber(String accountNumber){

    return accountMapper.toDomain(accountRepository.findByAccountNumber(accountNumber));

  }
}
