package com.financial.analysis.persistence.repository;

import com.financial.analysis.persistence.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String userName);

}
