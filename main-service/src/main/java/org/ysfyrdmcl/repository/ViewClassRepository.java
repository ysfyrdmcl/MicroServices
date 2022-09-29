package org.ysfyrdmcl.repository;

import org.ysfyrdmcl.repository.entity.ViewClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewClassRepository extends JpaRepository<ViewClass,Long> {
}
