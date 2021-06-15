package com.example.miniusos.repositories;

import com.example.miniusos.model.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional <User> findByUserName (String userName);
}
