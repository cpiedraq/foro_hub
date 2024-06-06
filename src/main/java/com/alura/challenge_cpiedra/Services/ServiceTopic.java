package com.alura.challenge_cpiedra.Services;

import com.alura.challenge_cpiedra.DtoGetData.topics.DtoCreateTopic;
import com.alura.challenge_cpiedra.DtoGetData.topics.DtoCreateTopicToDatabase;
import com.alura.challenge_cpiedra.DtoGetData.topics.DtoTopicSearchTitleAndYear;
import com.alura.challenge_cpiedra.DtoGetData.topics.DtoUpdateTopic;
import com.alura.challenge_cpiedra.DtoResponses.topics.DtoResponseDeleteTopic;
import com.alura.challenge_cpiedra.DtoResponses.topics.DtoResponseGetDataTopic;
import com.alura.challenge_cpiedra.DtoResponses.topics.DtoResponseTopic;
import com.alura.challenge_cpiedra.DtoResponses.user.DtoUser;
import com.alura.challenge_cpiedra.Services.validation.IValidationTopic;
import com.alura.challenge_cpiedra.databaseRepositories.*;
import com.alura.challenge_cpiedra.models.*;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceTopic
{
    @Autowired
    TopicRepository topicRepository;

    @Autowired
    ResponsesRepository responsesRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    List<IValidationTopic> validationTopics;

    public List<DtoResponseGetDataTopic> getAllDataTopic()
    {
        List<Topic> listTopics = topicRepository.findAll();
        List<DtoResponseGetDataTopic> topics = new ArrayList<>();

        for(Topic t :listTopics)
        {
            DtoResponseGetDataTopic dataTopic =fillDtoGetDataTopic(t);

            topics.add(dataTopic);
        }

        return topics;
    }

    public DtoResponseGetDataTopic createTopic(DtoCreateTopic dtoCreateTopic)
    {
        //Find the objects with the IDs
        Optional<User> userGetter = userRepository.findById(Long.valueOf(dtoCreateTopic.user()));
        Optional<Course> courseGetter = courseRepository.findById(Long.valueOf(dtoCreateTopic.course()));
        Optional<Status> statusGetter =statusRepository.findById(Long.valueOf(1));

        if(userGetter.isEmpty())
        {
            throw new ValidationException("The user not exist, please check the code");
        }

        if(courseGetter.isEmpty())
        {
            throw new ValidationException("The course not exist, please check the course code");
        }

        if(statusGetter.isEmpty())
        {
            throw new ValidationException("The status not exist, please check the status code");
        }

        DtoCreateTopicToDatabase dtoCreateTopicToDatabase = new DtoCreateTopicToDatabase(
                dtoCreateTopic.title(),
                dtoCreateTopic.message(),
                userGetter.get(),
                courseGetter.get(),
                statusGetter.get()
        );

        validationTopics.forEach(t -> t.checkValidation(dtoCreateTopicToDatabase));

        Topic topicData = new Topic(dtoCreateTopicToDatabase);

        topicRepository.save(topicData);

        DtoResponseGetDataTopic dataTopic =fillDtoGetDataTopic(topicData);

        return dataTopic;
    }

    public DtoResponseGetDataTopic getTopicById(Long id)
    {
        Optional<Topic> optional_Topic = topicRepository.findById(id);

        if(optional_Topic.isEmpty())
        {
            throw new ValidationException("The topic is not present, please check the code");
        }

        Topic topicData = optional_Topic.get();

        DtoResponseGetDataTopic dataTopic =fillDtoGetDataTopic(topicData);

        return dataTopic;
    }

    public DtoResponseGetDataTopic updateTopic(Long id, DtoUpdateTopic dtoUpdateTopic)
    {
        Optional<Topic> topicGetter = topicRepository.findById(id);

        if(topicGetter.isEmpty())
        {
            throw new ValidationException("The topic does not exist, please check the code");
        }

        Topic topic = topicGetter.get();

        Optional<User> userGetter = userRepository.findById(Long.valueOf(dtoUpdateTopic.user()));
        Optional<Course> courseGetter = courseRepository.findById(Long.valueOf(dtoUpdateTopic.course()));
        Optional<Status> statusGetter =statusRepository.findById(Long.valueOf(1));

        if(userGetter.isEmpty())
        {
            throw new ValidationException("The user does not exist");
        }

        if(courseGetter.isEmpty())
        {
            throw new ValidationException("The course does not exist");
        }

        if(statusGetter.isEmpty())
        {
            throw new ValidationException("The status does not exist");
        }

        topic.setMessage(dtoUpdateTopic.message());
        topic.setTitle(dtoUpdateTopic.title());
        topic.setAuthor(userGetter.get());
        topic.setCourse(courseGetter.get());
        topic.setStatus(statusGetter.get());

        DtoResponseGetDataTopic dtoResponseGetDataTopic = fillDtoGetDataTopic(topic);

        return dtoResponseGetDataTopic;
    }

    public DtoResponseDeleteTopic DeleteTopic(Long id)
    {
        DtoResponseDeleteTopic dtoResponseDeleteTopic = new DtoResponseDeleteTopic(200,
                "The record has been removed");

        topicRepository.deleteById(id);

        return dtoResponseDeleteTopic;
    }

    public List<DtoResponseGetDataTopic> findLastTenRecords()
    {
        List<Topic> listTopics = topicRepository.findLastTenRecordsByCreationDate();
        List<DtoResponseGetDataTopic> topics = new ArrayList<>();

        for(Topic t :listTopics)
        {
            DtoResponseGetDataTopic dataTopic =fillDtoGetDataTopic(t);

            topics.add(dataTopic);
        }

        return topics;
    }

    public List<DtoResponseGetDataTopic> findTopicByTitleAndYear(DtoTopicSearchTitleAndYear dtoTopicSearchTitleAndYear)
    {
        List<Topic> listTopics = topicRepository.findTopicByCourseNameAndYear(dtoTopicSearchTitleAndYear.courseName(),
                dtoTopicSearchTitleAndYear.year());
        List<DtoResponseGetDataTopic> topics = new ArrayList<>();

        for(Topic t :listTopics)
        {
            DtoResponseGetDataTopic dataTopic =fillDtoGetDataTopic(t);

            topics.add(dataTopic);
        }

        return topics;
    }

    public DtoResponseGetDataTopic fillDtoGetDataTopic(Topic topicData)
    {
        List<Responses> listResponses = responsesRepository.findByTopic(topicData);

        //Obtain the list of Responses
        List<DtoResponseTopic> listDtoResponseTopic = listResponses.stream()
                .map(r -> new DtoResponseTopic(r.getCreationdate(),
                        r.getMessage(),
                        r.getSolution(),
                        new DtoUser(r.getAuthor().getUsername(), r.getAuthor().getEmail())))
                .toList();

        DtoResponseGetDataTopic dtoResponseGetDataTopic = new DtoResponseGetDataTopic(
                topicData.getCode(),
                topicData.getTitle(),
                topicData.getMessage(),
                topicData.getCreationDate(),
                topicData.getStatus().getDescription(),
                new DtoUser(topicData.getAuthor().getUsername(), topicData.getAuthor().getEmail()),
                topicData.getCourse().getName(),
                listDtoResponseTopic
        );

        return dtoResponseGetDataTopic;
    }
}
