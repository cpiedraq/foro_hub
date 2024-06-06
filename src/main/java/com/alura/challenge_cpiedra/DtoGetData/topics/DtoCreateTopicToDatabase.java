package com.alura.challenge_cpiedra.DtoGetData.topics;

import com.alura.challenge_cpiedra.models.Course;
import com.alura.challenge_cpiedra.models.Status;
import com.alura.challenge_cpiedra.models.User;

public record DtoCreateTopicToDatabase (
        String title,
        String message,
        User user,
        Course course,
        Status status
)
{
}
