package com.financial.analysis.persistence.repository;

import com.financial.analysis.entitys.User;
import com.financial.analysis.service.user.impl.CustomUserException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String userName);

}
