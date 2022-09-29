package org.ysfyrdmcl.services;

import org.ysfyrdmcl.repository.JoinStateRepository;

import org.springframework.stereotype.Service;
import org.ysfyrdmcl.repository.entity.JoinState;

@Service
public class JoinStateService extends ServiceManager<JoinState,Long> {
    private final JoinStateRepository joinStateRepository;

    public JoinStateService(JoinStateRepository joinStateRepository) {
        super(joinStateRepository);
        this.joinStateRepository=joinStateRepository;
    }
}
