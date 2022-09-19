package com.refactorizando.example.user.mockresttemplate.exception;

public class UserException  extends RuntimeException {

    public UserException(String errorMessage) {
      super(errorMessage);
    }

    public UserException(String errorMessage, Throwable th) {
      super(errorMessage, th);
    }
  }


