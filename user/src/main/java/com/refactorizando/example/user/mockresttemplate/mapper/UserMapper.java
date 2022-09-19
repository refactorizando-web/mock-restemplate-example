package com.refactorizando.example.user.mockresttemplate.mapper;

import com.refactorizando.example.user.mockresttemplate.domain.User;
import com.refactorizando.example.user.mockresttemplate.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserEntity toEntity(User user);

  User toDomain(UserEntity entity);
}
