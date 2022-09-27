package org.ysfyrdmcl.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;



@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorType {
    INTERNAL_ERROR(2000, "Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001, "Invalid Parameter Error",HttpStatus.BAD_REQUEST),
    USER_CREATE_ERROR(3001,"User yaratılamadı",HttpStatus.INTERNAL_SERVER_ERROR),
    LOGIN_ERROR_WRONG(1000,"Kullanıcı adı yada şifre hatalı",HttpStatus.INTERNAL_SERVER_ERROR),
    LOGIN_ERROR_REQUIRED_PASSWORD(1001,"Şifre zorunlulukları, geçerli bir şifre giriniz",HttpStatus.INTERNAL_SERVER_ERROR),
    LOGIN_ERROR_USERNAME_ERROR(1002,"Geçerli bir kullanıcı adı giriniz. ",HttpStatus.INTERNAL_SERVER_ERROR),
    LOGIN_ERROR_USERNAME_DUPLICATE(1003,"Bu Kullanıcı adı zaten kullanılıyor.",HttpStatus.INTERNAL_SERVER_ERROR);
    private int code;
    private String message;
    HttpStatus httpStatus;
}
