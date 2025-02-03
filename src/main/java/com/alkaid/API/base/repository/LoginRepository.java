package com.alkaid.API.base.repository;

import com.alkaid.API.base.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface LoginRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsernameAndPasswordAndToken(String username,String password,String token);
    Optional<User> findByUsernameAndPassword(String username,String password);
}
