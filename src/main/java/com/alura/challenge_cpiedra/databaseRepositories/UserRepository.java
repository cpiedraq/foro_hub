package com.alura.challenge_cpiedra.databaseRepositories;

import com.alura.challenge_cpiedra.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long>
{
    User findByUsername(String username);
}