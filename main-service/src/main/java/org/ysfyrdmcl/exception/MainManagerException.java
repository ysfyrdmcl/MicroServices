package org.ysfyrdmcl.exception;

import lombok.Getter;

@Getter

public class MainManagerException extends RuntimeException{
    private final ErrorType errorType;

    public MainManagerException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType=errorType;
    }
    public MainManagerException(ErrorType errorType, String cause){
        super(cause);
        this.errorType=errorType;

    }
}
