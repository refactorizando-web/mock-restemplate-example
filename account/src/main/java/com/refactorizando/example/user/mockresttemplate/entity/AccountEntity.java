package com.refactorizando.example.user.mockresttemplate.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ACCOUNT")
public class AccountEntity extends AuditEntity{

  @Column(name = "ACCOUNT_ID")
  @Id
  @Type(type="org.hibernate.type.UUIDCharType")
  @GeneratedValue
  private UUID accountId;

  @Column(name = "ACCOUNT_NUMBER")
  private String accountNumber;

  @Column(name = "CREATED_DATE")
  private LocalDate createdDate;

  private BigDecimal amount;

  @Column(name = "USER_ID")
  private String userId;
}
