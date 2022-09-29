package org.ysfyrdmcl.services;

import org.ysfyrdmcl.repository.GroupNameClassRepository;

import org.springframework.stereotype.Service;
import org.ysfyrdmcl.repository.entity.GroupNameClass;

@Service
public class GroupNameClassService extends ServiceManager<GroupNameClass,Long> {
    private final GroupNameClassRepository groupNameClassRepository;

    public GroupNameClassService(GroupNameClassRepository groupNameClassRepository) {
        super(groupNameClassRepository);
        this.groupNameClassRepository = groupNameClassRepository;
    }
}
