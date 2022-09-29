package org.ysfyrdmcl.services;



import org.springframework.data.jpa.repository.JpaRepository;
import org.ysfyrdmcl.repository.entity.State;
import org.ysfyrdmcl.repository.entity.SuperClass;

import java.util.Date;
import java.util.List;

public class ServiceManager <T extends  SuperClass,ID> implements IService<T,ID>{
    private final JpaRepository<T,ID> service;


    public ServiceManager(JpaRepository<T, ID> service) {
        this.service = service;
    }

    @Override
    public T save(T entity) {
        return service.save(entity);
    }


    @Override
    public T update(T entity) {
        entity.setUpdatedDate(new Date());
        return service.save(entity);
    }

    @Override
    public void deleteById(ID id) {
       T entity= service.getReferenceById(id);
        entity.setUpdatedDate(new Date());
       entity.setState(State.PASSIVE);
    }

    @Override
    public T findById(ID id) {
        return service.getReferenceById(id);
    }

    @Override
    public List<T> findAll() {
        return service.findAll();
    }
}
