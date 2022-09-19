package com.refactorizando.example.user.mockresttemplate.service;

import com.refactorizando.example.user.mockresttemplate.domain.Account;
import com.refactorizando.example.user.mockresttemplate.domain.User;
import com.refactorizando.example.user.mockresttemplate.exception.UserException;
import com.refactorizando.example.user.mockresttemplate.mapper.UserMapper;
import com.refactorizando.example.user.mockresttemplate.repository.UserRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

  private static final String URL = "http://localhost:8081/accounts/{account}";

  private final RestTemplate restTemplate;

  private final UserRepository userRepository;

  private final UserMapper userMapper;

  public User getUserByAccountNumber(String accountNumber){

    User user = userMapper.toDomain(userRepository.findByAccountNumber(accountNumber));

    if (null != user) {

      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);

      MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
      map.add("account", accountNumber);


      HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
      HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

      ResponseEntity<Account> response = restTemplate.exchange(
          URL, HttpMethod.GET, requestEntity, Account.class, accountNumber);

      user.setAccount(response.getBody());

      return user;
    }

    throw new UserException("User not found for accountNumber " + accountNumber);
  }
}
