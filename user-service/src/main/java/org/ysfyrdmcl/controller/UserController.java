package org.ysfyrdmcl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ysfyrdmcl.dto.request.EditProfileRequestDto;
import org.ysfyrdmcl.dto.request.NewUserCreateDto;
import org.ysfyrdmcl.exception.ErrorType;
import org.ysfyrdmcl.exception.UserManagerException;
import org.ysfyrdmcl.services.UserService;
import org.ysfyrdmcl.utility.JwtTokenManager;

import javax.validation.Valid;

import java.util.Optional;

import static org.ysfyrdmcl.constans.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL+USER)
@RequiredArgsConstructor
public class UserController {
   private final UserService userService;
   private final JwtTokenManager jwtTokenManager;
    @PostMapping(NEW_CREATE_USER)
    public ResponseEntity<Boolean> newUserCreate(@RequestBody @Valid NewUserCreateDto dto){
        try{
            userService.createUserProfile(dto);
            return ResponseEntity.ok().body(true);
        }
        catch (Exception e){
            throw  new UserManagerException(ErrorType.USER_CREATE_ERROR);
        }


    }
    @PostMapping(UPDATE_PROFILE)
    public ResponseEntity<Boolean> updateProfile(@RequestBody @Valid EditProfileRequestDto dto){
        if(dto.getToken()==null)
            throw new UserManagerException(ErrorType.INVALID_TOKEN);
        try{
            Optional<Long> authid = jwtTokenManager.getUserId(dto.getToken());
            if (authid.isEmpty())
                throw new UserManagerException(ErrorType.INVALID_TOKEN);

            return ResponseEntity.ok(userService.updateUserProfile(dto,authid.get()));
        }catch (Exception exception){
            throw new UserManagerException(ErrorType.INVALID_TOKEN);
        }



    }
}
