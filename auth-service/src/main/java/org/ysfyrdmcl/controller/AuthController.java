package org.ysfyrdmcl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static org.ysfyrdmcl.constans.ApiUrls.*;


import org.ysfyrdmcl.dto.request.DoLoginRequest;
import org.ysfyrdmcl.dto.request.RegisterRequestDto;
import org.ysfyrdmcl.exception.AuthManagerException;
import org.ysfyrdmcl.exception.ErrorType;
import org.ysfyrdmcl.repository.entity.Auth;
import org.ysfyrdmcl.repository.enums.Roles;
import org.ysfyrdmcl.services.AuthService;
import org.ysfyrdmcl.config.security.JwtTokenManager;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(BASE_URL+AUTH)
@RequiredArgsConstructor

public class AuthController {
    private final AuthService authService;
    private final JwtTokenManager jwtTokenManager;
    //authorize için.
    //@PreAuthorize("hasAuthory('USER')")
    @GetMapping("/test")
    public String getTestString(String token){


            if(token==null)
                throw new AuthManagerException(ErrorType.INVALID_TOKEN);
            try{
                Optional<Long> authid = jwtTokenManager.getUserId(token);
                if (authid.isEmpty()) {
                    throw new AuthManagerException(ErrorType.INVALID_TOKEN);
                }
                Roles roles = authService.getRoles(authid).get();
                if (roles == Roles.USER ){
                    return "Auth Test for users";
                }
                else
                    return null;
            }catch (Exception exception){
                throw new AuthManagerException(ErrorType.INVALID_TOKEN);
            }

    }
    @PostMapping(LOGIN)
    public ResponseEntity<String> doLogin(@RequestBody @Valid DoLoginRequest dto){
        Optional<Auth> auth = authService.dologin(dto);
        if(auth.isPresent()){
            String token = jwtTokenManager.createToken(auth.get().getId()).get();
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().body("Giriş Başarısız");
    }
    @PostMapping(REGISTER)
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequestDto dto){
        authService.register(dto);
        return ResponseEntity.ok().build();
    }

}