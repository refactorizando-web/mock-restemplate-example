package com.refactorizando.example.user.mockresttemplate.entity;

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
public class UserEntity extends AuditEntity{

  @Column(name = "USER_ID")
  @Id
  @Type(type="org.hibernate.type.UUIDCharType")
  @GeneratedValue
  private UUID userId;

  private String name;

  private String surname;

  private String address;

  @Column(name="ACCOUNT_NUMBER")
  private String accountNumber;
}
