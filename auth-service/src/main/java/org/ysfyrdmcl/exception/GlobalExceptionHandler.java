package org.ysfyrdmcl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex){
        return ResponseEntity.ok("Beklenmeyen bir hata: "+ ex.getMessage());
    }
    @ExceptionHandler(AuthManagerException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage>handleMonolitikException(AuthManagerException ex){
        ErrorType errorType=ex.getErrorType();
        HttpStatus httpStatus=errorType.getHttpStatus();
        return new ResponseEntity<>(createErrorMessage(errorType,ex),httpStatus
        );
    }
    private ErrorMessage createErrorMessage(ErrorType errorType,Exception ex){
        System.out.println("Hata oluştu"+ex.getMessage());
        return ErrorMessage.builder()
                .code(errorType.getCode())
                .message(errorType.getMessage())
                .build();
    }
}
