package org.ysfyrdmcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.ysfyrdmcl.repository.entity.Auth;

import java.util.Optional;

@Repository
public interface IAuthRepository extends JpaRepository<Auth,Long> {
    Optional<Auth>findOptionalByUsernameIgnoreCaseAndPassword(String username,String password);
    @Query("select COUNT(a)>0 from Auth a where  UPPER(a.username) =  UPPER(?1) and a.password = ?2")
    boolean isExists(String username, String password);

    Optional<Auth> findOptionalById(Long authid);
}
