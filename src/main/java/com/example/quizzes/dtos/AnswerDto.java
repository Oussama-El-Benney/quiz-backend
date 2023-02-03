package com.example.quizzes.dtos;

import com.example.quizzes.entities.Question;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AnswerDto {

    private Long questionId;
    private String userChoice;
}
