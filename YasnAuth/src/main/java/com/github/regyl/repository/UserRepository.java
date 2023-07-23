package com.github.regyl.repository;

import com.github.regyl.dto.PasswordContainer;
import com.github.regyl.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

    @Query("select u.password from User u where u.username = #{username}")
    Optional<PasswordContainer> findPasswordByUsername(String username);
}
