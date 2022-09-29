package org.ysfyrdmcl.services;

import org.ysfyrdmcl.repository.CompetitionRepository;

import org.springframework.stereotype.Service;
import org.ysfyrdmcl.repository.entity.Competition;

@Service
public class CompetitionService extends ServiceManager<Competition,Long> {
    private final CompetitionRepository competitionRepository;

    public CompetitionService(CompetitionRepository competitionRepository) {
        super(competitionRepository);
        this.competitionRepository = competitionRepository;
    }
}
