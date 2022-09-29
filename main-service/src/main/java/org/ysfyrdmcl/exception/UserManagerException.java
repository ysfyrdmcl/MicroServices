package org.ysfyrdmcl.exception;

import lombok.Getter;

@Getter

public class UserManagerException extends RuntimeException{
    private final ErrorType errorType;

    public UserManagerException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }
    public UserManagerException(ErrorType errorType, String cause){
        super(cause);
        this.errorType=errorType;

    }
}
