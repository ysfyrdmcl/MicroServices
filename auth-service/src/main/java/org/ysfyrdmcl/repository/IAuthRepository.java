package org.ysfyrdmcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ysfyrdmcl.repository.entity.Auth;
@Repository
public interface IAuthRepository extends JpaRepository<Auth,Long> {
}
