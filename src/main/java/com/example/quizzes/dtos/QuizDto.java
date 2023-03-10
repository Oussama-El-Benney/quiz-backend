package com.example.quizzes.dtos;

import com.example.quizzes.entities.Quiz;
import lombok.Data;

@Data
public class QuizDto extends Quiz {
    private Long id;
    private String name;
    private String description;
}
