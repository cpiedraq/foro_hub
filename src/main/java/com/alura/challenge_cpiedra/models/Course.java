package com.alura.challenge_cpiedra.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "course")
@Entity
@Getter
@NoArgsConstructor
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code;

    private String name;
    private String category;
}
