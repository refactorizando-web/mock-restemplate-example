package com.refactorizando.example.user.mockresttemplate.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

  private String accountNumber;

  private LocalDate createdDate;

  private BigDecimal amount;

  private String userId;

}
