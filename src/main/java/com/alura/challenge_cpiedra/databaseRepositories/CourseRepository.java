package com.alura.challenge_cpiedra.databaseRepositories;

import com.alura.challenge_cpiedra.models.Course;
import com.alura.challenge_cpiedra.models.Responses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>
{
}
