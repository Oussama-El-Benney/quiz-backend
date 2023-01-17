package com.example.quizzes.dtos;

import com.example.quizzes.entities.Quiz;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


public class QuestionDto {

    private Long id;
    private String question;
    private List<String> choices = new ArrayList<>();
    private String correctChoice;
    private Long quizFatherId;

}
