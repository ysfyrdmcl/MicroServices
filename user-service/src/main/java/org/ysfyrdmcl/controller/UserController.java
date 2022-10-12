package org.ysfyrdmcl.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ysfyrdmcl.dto.request.EditProfileRequestDto;
import org.ysfyrdmcl.dto.request.NewUserCreateDto;
import org.ysfyrdmcl.exception.ErrorType;
import org.ysfyrdmcl.exception.UserManagerException;
import org.ysfyrdmcl.repository.entity.UserProfile;
import org.ysfyrdmcl.services.UserService;
import org.ysfyrdmcl.utility.JwtTokenManager;

import javax.validation.Valid;


import java.util.Optional;

import static org.ysfyrdmcl.constans.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL+USER)
@RequiredArgsConstructor
@Slf4j
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
    @GetMapping(FINDALL)
    public ResponseEntity<Page<UserProfile>> findAll(int currentPage, int pageSize,  String sortParameter, String direction){
        return ResponseEntity.ok(userService.findAllPage(currentPage,pageSize, sortParameter, direction));
    }
    @GetMapping(FINDALL+"slice")
    public ResponseEntity<Slice<UserProfile>> findAllSlice(int currentPage, int pageSize, String sortParameter, String direction){
        return ResponseEntity.ok(userService.findAllSlice(currentPage,pageSize, sortParameter, direction));
    }

//    @GetMapping("/redis")
//    @Cacheable(value = "hello_redis")
//    public String helloRedis(String message){
//        try{
//            Thread.sleep(3000);
//            return "Mesajınız.....: "+ message;
//        }catch (Exception e){
//            log.error("Hata: "+e.getMessage());
//            return "HATA";
//        }
//    }

//    @GetMapping("/clearcache")
//    public void ClearCache(String key,String parameter){
//        userService.clearCache(key,parameter);
//    }
}
