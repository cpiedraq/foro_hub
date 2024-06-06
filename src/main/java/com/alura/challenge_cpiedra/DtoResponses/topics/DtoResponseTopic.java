package com.alura.challenge_cpiedra.DtoResponses.topics;

import com.alura.challenge_cpiedra.DtoResponses.user.DtoUser;

import java.time.LocalDateTime;

public record DtoResponseTopic (
        LocalDateTime creationDate,
        String message,
        String solution,
        DtoUser author
)
{
}
