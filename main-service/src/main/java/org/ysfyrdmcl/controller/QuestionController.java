package org.ysfyrdmcl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ysfyrdmcl.dto.request.QuestionPackageDto;
import org.ysfyrdmcl.exception.ErrorType;
import org.ysfyrdmcl.exception.MainManagerException;
import org.ysfyrdmcl.services.JwtTokenManager;
import org.ysfyrdmcl.services.QuestionService;

import javax.validation.Valid;

import java.util.Optional;

import static org.ysfyrdmcl.constans.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL+MAIN+QUESTION)
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    private final JwtTokenManager jwtTokenManager;

    @PostMapping(CREATE)
    public ResponseEntity<Void> createSoru(@RequestBody @Valid QuestionPackageDto dto){
        try{
            Optional<Long> userid = jwtTokenManager.getUserId(dto.getToken());
            if(userid.isEmpty()) throw new MainManagerException(ErrorType.INVALID_TOKEN);
            questionService.save(dto);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            throw new MainManagerException(ErrorType.INVALID_TOKEN);
        }
    }
}
