package org.ysfyrdmcl.repository;

import org.ysfyrdmcl.repository.entity.Rankings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingsRepository extends JpaRepository<Rankings,Long> {
}
