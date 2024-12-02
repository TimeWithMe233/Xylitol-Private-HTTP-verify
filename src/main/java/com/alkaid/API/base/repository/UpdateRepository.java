package com.alkaid.API.base.repository;

import com.alkaid.API.base.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdateRepository extends JpaRepository<User, Integer> {
}
