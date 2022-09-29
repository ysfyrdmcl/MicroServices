package org.ysfyrdmcl.services;

import org.ysfyrdmcl.repository.ViewClassRepository;
import org.ysfyrdmcl.repository.entity.ViewClass;
import org.springframework.stereotype.Service;

@Service
public class ViewClassService extends ServiceManager<ViewClass,Long> {
    private final ViewClassRepository viewClassRepository;

    public ViewClassService(ViewClassRepository viewClassRepository) {
        super(viewClassRepository);
        this.viewClassRepository = viewClassRepository;
    }
}
