package com.example.quizzes.dtos;

import com.example.quizzes.entities.Question;
import com.example.quizzes.entities.Quiz;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionDto extends Question {

    private Long id;
    private String question;
    private List<String> choices = new ArrayList<>();
    private String correctChoice;
    private Long quizFatherId;

}
