package org.ysfyrdmcl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ysfyrdmcl.dto.request.NewUserCreateDto;
import org.ysfyrdmcl.exception.ErrorType;
import org.ysfyrdmcl.exception.UserManagerException;
import org.ysfyrdmcl.services.UserService;

import static org.ysfyrdmcl.constans.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL+USER)
@RequiredArgsConstructor
public class UserController {
   private final UserService userService;
    @PostMapping(NEW_USER)
    public ResponseEntity<Boolean> newUserCreate(NewUserCreateDto dto){
        try{
            userService.createUserProfile(dto);
            return ResponseEntity.ok().body(true);
        }
        catch (Exception e){
            throw  new UserManagerException(ErrorType.USER_CREATE_ERROR);
        }


    }
}
