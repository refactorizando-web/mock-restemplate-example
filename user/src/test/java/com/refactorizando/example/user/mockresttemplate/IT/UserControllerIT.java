package com.refactorizando.example.user.mockresttemplate.IT;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.refactorizando.example.user.mockresttemplate.UserMockResttemplateApplication;
import com.refactorizando.example.user.mockresttemplate.domain.Account;
import com.refactorizando.example.user.mockresttemplate.domain.User;
import com.refactorizando.example.user.mockresttemplate.entity.UserEntity;
import com.refactorizando.example.user.mockresttemplate.repository.UserRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;


@SpringBootTest(classes = {
    UserMockResttemplateApplication.class}, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerIT {

  private static final String URI = "/users/{accountNumber}";
  private MockRestServiceServer mockServer;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private UserRepository userRepository;

  @BeforeEach
  public void init() {
    mockServer = MockRestServiceServer.createServer(restTemplate);

  }

  @Test
  public void given_account_number_when_user_account_is_requested_then_user_account_is_returned()
      throws Exception {

    Account account = Account.builder()
        .accountNumber("0060a6e2-f47e-42b5-8cb3-a45932920204")
        .amount(new BigDecimal(1.5))
        .createdDate(LocalDate.MAX).build();

    UserEntity user = new UserEntity();
    user.setUserId(UUID.fromString("0060a6e2-f47e-42b5-8cb3-a45932920204"));
    user.setAccountNumber("579f32b8-9a31-470c-a40c-723ffdc21291");
    user.setName("noel");
    userRepository.saveAndFlush(user);

    mockServer.expect(once(),
            requestTo("http://localhost:8081/accounts/579f32b8-9a31-470c-a40c-723ffdc21291"))
        .andRespond(
            withSuccess(objectMapper.writeValueAsString(account), MediaType.APPLICATION_JSON));

    String response = mockMvc.perform(
            MockMvcRequestBuilders.get(URI, "579f32b8-9a31-470c-a40c-723ffdc21291")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        User userReponse = objectMapper.readValue(response, User.class);

        assertTrue(userReponse.getAccountNumber().equalsIgnoreCase(user.getAccountNumber()));
        assertTrue(userReponse.getAccount().getAccountNumber().equalsIgnoreCase(
            account.getAccountNumber()));



  }
}
