package com.alura.challenge_cpiedra.Services.validation.topic;

import com.alura.challenge_cpiedra.DtoGetData.topics.DtoCreateTopicToDatabase;
import com.alura.challenge_cpiedra.DtoResponses.topics.DtoResponseGetDataTopic;
import com.alura.challenge_cpiedra.Services.validation.IValidationTopic;
import com.alura.challenge_cpiedra.databaseRepositories.TopicRepository;
import com.alura.challenge_cpiedra.models.Topic;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class validateNoEqualTitleOrMessage implements IValidationTopic
{
    @Autowired
    TopicRepository topicRepository;

    @Override
    public void checkValidation(DtoCreateTopicToDatabase dataTopic)
    {
        Topic topicData = topicRepository.findTopicByTitleOrMessage(dataTopic.title(), dataTopic.message());

        if(topicData != null)
        {
            throw new ValidationException("The topic exists with title or message description");
        }
    }
}
