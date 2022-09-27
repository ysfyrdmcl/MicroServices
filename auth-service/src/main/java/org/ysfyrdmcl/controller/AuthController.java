package org.ysfyrdmcl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.ysfyrdmcl.constans.ApiUrls.*;

import org.ysfyrdmcl.dto.request.DoLoginRequest;
import org.ysfyrdmcl.dto.request.RegisterRequestDto;
import org.ysfyrdmcl.services.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping(BASE_URL+AUTH)
@RequiredArgsConstructor

public class AuthController {
    private final AuthService authService;

    @PostMapping(LOGIN)
    public ResponseEntity<String> doLogin(@RequestBody DoLoginRequest dto){
        if( authService.doLogin(dto))
            return ResponseEntity.ok("Giriş başarılı");
        return ResponseEntity.badRequest().body("Giriş başarısız");
    }
    @PostMapping(REGISTER)
    public ResponseEntity<Void> register(@Valid @RequestBody RegisterRequestDto dto){
        authService.register(dto);
        return ResponseEntity.ok().build();
    }

}