package com.example.quizzes.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Quiz.class, name = "q1")
public interface QuizProjection {
    public Long getId();
    public String getName();
    public String getDescription();
}
