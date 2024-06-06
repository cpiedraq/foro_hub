package com.alura.challenge_cpiedra.databaseRepositories;

import com.alura.challenge_cpiedra.models.Course;
import com.alura.challenge_cpiedra.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
