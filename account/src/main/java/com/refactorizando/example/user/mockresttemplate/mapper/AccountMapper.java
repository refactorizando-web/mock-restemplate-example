package com.refactorizando.example.user.mockresttemplate.mapper;

import com.refactorizando.example.user.mockresttemplate.domain.Account;
import com.refactorizando.example.user.mockresttemplate.entity.AccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

  AccountEntity toEntity(Account account);

  Account toDomain(AccountEntity entity);
}
