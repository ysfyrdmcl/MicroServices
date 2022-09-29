package org.ysfyrdmcl.repository;

import org.ysfyrdmcl.repository.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition,Long> {
}
