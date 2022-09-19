package com.refactorizando.example.user.mockresttemplate.exception;

public class AccountException extends RuntimeException {

    public AccountException(String errorMessage) {
      super(errorMessage);
    }

    public AccountException(String errorMessage, Throwable th) {
      super(errorMessage, th);
    }
  }


