package org.ysfyrdmcl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ysfyrdmcl.dto.request.CompetitionRequestDto;
import org.ysfyrdmcl.exception.ErrorType;
import org.ysfyrdmcl.exception.MainManagerException;
import org.ysfyrdmcl.repository.entity.Competition;
import org.ysfyrdmcl.services.CompetitionService;
import org.ysfyrdmcl.services.JwtTokenManager;

import javax.validation.Valid;

import java.util.Optional;

import static org.ysfyrdmcl.constans.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL+MAIN+COMPETITION)
@RequiredArgsConstructor
public class CompetitionController {
    private final CompetitionService competitionService;
    private final JwtTokenManager jwtTokenManager;

    @PostMapping(CREATE)
    public ResponseEntity<Competition> createCompetition(@RequestBody @Valid CompetitionRequestDto dto){
        try {
            Optional<Long> userid = jwtTokenManager.getUserId(dto.getToken());
            if(userid.isEmpty()) throw new MainManagerException(ErrorType.INVALID_TOKEN);
            return ResponseEntity.ok(competitionService.save(dto));
        } catch (Exception e) {
            throw new MainManagerException(ErrorType.INVALID_TOKEN);
        }
    }

}
