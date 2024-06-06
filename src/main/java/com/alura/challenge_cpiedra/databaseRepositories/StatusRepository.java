package com.alura.challenge_cpiedra.databaseRepositories;

import com.alura.challenge_cpiedra.models.Course;
import com.alura.challenge_cpiedra.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
