package com.alkaid.API.base.repository;

import com.alkaid.API.base.model.Ban;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Author: DreamDev
 * @Date: 2024/10/26
 * Time:22:21
 */
public interface BanRepository extends JpaRepository<Ban, Integer> {
    Optional<Ban> findByUsername(String username);
    Optional<Ban> findByToken(String token);
    Optional<Ban> findByUsernameAndToken(String username, String token);
}
