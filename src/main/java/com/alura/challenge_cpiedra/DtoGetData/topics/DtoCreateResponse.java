package com.alura.challenge_cpiedra.DtoGetData.topics;

import com.alura.challenge_cpiedra.models.Topic;
import com.alura.challenge_cpiedra.models.User;

public record DtoCreateResponse (
        String message,
        int idTopic,
        int idAuthor,
        String solution
)
{
}
