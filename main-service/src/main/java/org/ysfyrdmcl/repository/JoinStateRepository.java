package org.ysfyrdmcl.repository;

import org.ysfyrdmcl.repository.entity.JoinState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoinStateRepository extends JpaRepository<JoinState,Long> {
}
