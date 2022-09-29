package org.ysfyrdmcl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.ysfyrdmcl.constans.ApiUrls.*;

import org.ysfyrdmcl.dto.request.DoLoginRequest;
import org.ysfyrdmcl.dto.request.RegisterRequestDto;
import org.ysfyrdmcl.repository.entity.Auth;
import org.ysfyrdmcl.services.AuthService;
import org.ysfyrdmcl.utility.JwtTokenManager;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(BASE_URL+AUTH)
@RequiredArgsConstructor

public class AuthController {
    private final AuthService authService;
    private final JwtTokenManager jwtTokenManager;
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