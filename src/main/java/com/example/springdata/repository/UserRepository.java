package com.example.springdata.repository;

import com.example.springdata.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    @Query("select u from User u where u.login = :login and u.name = :name")
    Optional<User> findByLoginAndName(@Param("login") String login,
                                      @Param("name") String name);

    Page<User> findByLogin(String login, Pageable pageable);
}
