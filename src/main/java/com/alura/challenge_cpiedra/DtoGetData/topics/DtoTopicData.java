package com.alura.challenge_cpiedra.DtoGetData.topics;

import com.alura.challenge_cpiedra.models.Course;
import com.alura.challenge_cpiedra.models.Status;
import com.alura.challenge_cpiedra.models.User;

import java.time.LocalDateTime;

public record DtoTopicData (
        String title,
        String message,
        LocalDateTime creationdate,
        Status status,
        User author,
        Course course
)
{
}
