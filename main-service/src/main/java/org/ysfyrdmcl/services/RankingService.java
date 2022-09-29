package org.ysfyrdmcl.services;

import org.ysfyrdmcl.repository.RankingsRepository;

import org.springframework.stereotype.Service;
import org.ysfyrdmcl.repository.entity.Rankings;

@Service
public class RankingService extends ServiceManager<Rankings,Long> {
    private final RankingsRepository rankingsRepository;

    public RankingService(RankingsRepository rankingsRepository) {
        super(rankingsRepository);
        this.rankingsRepository = rankingsRepository;
    }
}
