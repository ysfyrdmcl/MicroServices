package org.ysfyrdmcl.services;


import org.ysfyrdmcl.dto.request.CompetitionQuestionRequestDto;
import org.ysfyrdmcl.mapper.ICompetitionQuestionsMapper;


import org.springframework.stereotype.Service;

import org.ysfyrdmcl.repository.CompetitionQuestionRepository;
import org.ysfyrdmcl.repository.entity.CompetitionQuestions;

@Service
public class CompetitionQuestionService extends ServiceManager<CompetitionQuestions,Long> {
    private final CompetitionQuestionRepository competitionQuestionsRepository;

    public CompetitionQuestionService(CompetitionQuestionRepository competitionQuestionsRepository) {
        super(competitionQuestionsRepository);
        this.competitionQuestionsRepository=competitionQuestionsRepository;
    }


    public CompetitionQuestions create(CompetitionQuestionRequestDto dto){
        return save(ICompetitionQuestionsMapper.INSTANCE.toCompetitionQuestions(dto));
    }
}
