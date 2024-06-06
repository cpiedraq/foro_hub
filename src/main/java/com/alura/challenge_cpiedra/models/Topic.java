package com.alura.challenge_cpiedra.models;

import com.alura.challenge_cpiedra.DtoGetData.topics.DtoCreateTopicToDatabase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "topic")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Topic
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Code;
    private String title;
    private String message;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @JoinColumn(name="status", referencedColumnName="code")
    @OneToOne
    private Status status;

    @JoinColumn(name="author", referencedColumnName="code")
    @OneToOne
    private User author;

    @JoinColumn(name="course", referencedColumnName="code")
    @OneToOne
    private Course course;

    public Topic(DtoCreateTopicToDatabase dtoCreateTopicToDatabase)
    {
        this.title = dtoCreateTopicToDatabase.title();
        this.message = dtoCreateTopicToDatabase.message();
        this.creationDate = LocalDateTime.now();
        this.author = dtoCreateTopicToDatabase.user();
        this.course = dtoCreateTopicToDatabase.course();
        this.status = dtoCreateTopicToDatabase.status();
    }
}
