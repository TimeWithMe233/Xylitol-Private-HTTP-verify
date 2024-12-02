package com.alkaid.API.base.repository;

import com.alkaid.API.base.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Integer> {
    Optional<Card> findByCode(String code);
}
