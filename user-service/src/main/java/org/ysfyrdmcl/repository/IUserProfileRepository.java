package org.ysfyrdmcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ysfyrdmcl.repository.entity.UserProfile;

@Repository
public interface IUserProfileRepository extends JpaRepository<UserProfile,Long> {
}
