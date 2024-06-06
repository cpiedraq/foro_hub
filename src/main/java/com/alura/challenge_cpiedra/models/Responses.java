package com.alura.challenge_cpiedra.models;

import com.alura.challenge_cpiedra.DtoGetData.topics.DtoCreateResponseToDatabase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "responses")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Responses
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;

    private String message;

    private LocalDateTime creationdate;

    private String solution;

    @JoinColumn(name="author", referencedColumnName="code")
    @OneToOne
    private User author;

    @JoinColumn(name="topic", referencedColumnName="code")
    @OneToOne
    private Topic topic;

    public Responses(DtoCreateResponseToDatabase dtoCreateResponseToDatabase)
    {
        this.message = dtoCreateResponseToDatabase.message();
        this.creationdate = LocalDateTime.now();
        this.author = dtoCreateResponseToDatabase.author();
        this.topic = dtoCreateResponseToDatabase.topic();
        this.solution = dtoCreateResponseToDatabase.solution();
    }

}
