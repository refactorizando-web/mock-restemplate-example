package com.refactorizando.example.user.mockresttemplate.repository;

import com.refactorizando.example.user.mockresttemplate.entity.UserEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

  UserEntity findByAccountNumber(String accountNumber);

  UserEntity findByName(String name);




}
