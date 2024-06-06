package com.alura.challenge_cpiedra.Services.validation;

import com.alura.challenge_cpiedra.DtoGetData.topics.DtoCreateTopicToDatabase;
import com.alura.challenge_cpiedra.DtoResponses.topics.DtoResponseGetDataTopic;

public interface IValidationTopic {

    public void checkValidation(DtoCreateTopicToDatabase dataTopic);
}
