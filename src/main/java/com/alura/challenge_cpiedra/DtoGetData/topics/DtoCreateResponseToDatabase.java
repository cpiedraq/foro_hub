package com.alura.challenge_cpiedra.DtoGetData.topics;

import com.alura.challenge_cpiedra.models.Topic;
import com.alura.challenge_cpiedra.models.User;

public record DtoCreateResponseToDatabase(
        String message,
        Topic topic,
        User author,
        String solution
) {
}
