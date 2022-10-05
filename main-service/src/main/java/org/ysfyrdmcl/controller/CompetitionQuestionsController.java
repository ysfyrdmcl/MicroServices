package org.ysfyrdmcl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ysfyrdmcl.dto.request.CompetitionQuestionRequestDto;
import org.ysfyrdmcl.exception.ErrorType;
import org.ysfyrdmcl.exception.MainManagerException;
import org.ysfyrdmcl.repository.entity.CompetitionQuestions;
import org.ysfyrdmcl.services.CompetitionQuestionService;
import org.ysfyrdmcl.services.JwtTokenManager;

import java.util.Optional;

import static org.ysfyrdmcl.constans.ApiUrls.*;

@RestController
@RequestMapping(BASE_URL+MAIN+COMPETITIONQUESTIONS)
@RequiredArgsConstructor
public class CompetitionQuestionsController {
    private final CompetitionQuestionService competitionQuestionService;
    private final JwtTokenManager jwtTokenManager;

    @PostMapping(CREATE)
    public ResponseEntity<CompetitionQuestions> createYarismaSoru(CompetitionQuestionRequestDto dto) {
        try {
            Optional<Long> userId = jwtTokenManager.getUserId(dto.getToken());
            if(userId.isEmpty()) throw  new MainManagerException(ErrorType.INVALID_TOKEN);
            return ResponseEntity.ok(competitionQuestionService.create(dto));
        } catch (Exception e) {
            throw  new MainManagerException(ErrorType.INVALID_TOKEN);
        }
    }
}
