package org.ysfyrdmcl.services;

import org.ysfyrdmcl.repository.CompetitionRepository;

import org.springframework.stereotype.Service;
import org.ysfyrdmcl.repository.entity.Competition;

@Service
public class CompetitionQuestionService extends ServiceManager<Competition,Long> {
    private final CompetitionRepository competitionRepository;

    public CompetitionQuestionService(CompetitionRepository competitionRepository) {
        super(competitionRepository);
        this.competitionRepository = competitionRepository;
    }
}
