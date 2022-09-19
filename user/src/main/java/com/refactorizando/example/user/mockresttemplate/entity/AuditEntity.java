package com.refactorizando.example.user.mockresttemplate.entity;

import java.time.LocalDate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public abstract class AuditEntity {

  @CreatedDate
  private LocalDate createdDate;

  @LastModifiedDate
  private LocalDate modifiedDate;
}
