package com.refactorizando.example.user.mockresttemplate.repository;

import com.refactorizando.example.user.mockresttemplate.entity.AccountEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {

  AccountEntity findByAccountNumber(String accountNumber);

}
