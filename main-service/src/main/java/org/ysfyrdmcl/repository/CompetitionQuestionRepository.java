package org.ysfyrdmcl.repository;

import org.ysfyrdmcl.repository.entity.CompetitionQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionQuestionRepository extends JpaRepository<CompetitionQuestions,Long> {
}
