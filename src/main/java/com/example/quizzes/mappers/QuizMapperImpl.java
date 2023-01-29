package com.example.quizzes.mappers;

import com.example.quizzes.dtos.QuestionDto;
import com.example.quizzes.dtos.QuizDto;
import com.example.quizzes.entities.Question;
import com.example.quizzes.entities.Quiz;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class QuizMapperImpl {

    public QuizDto fromQuiz(Quiz Quiz) {
        QuizDto QuizDTO = new QuizDto();
        BeanUtils.copyProperties(Quiz, QuizDTO);
        return QuizDTO;
    }


    public Quiz fromQuizDTO(QuizDto QuizDTO) {
        Quiz Quiz = new Quiz();
        BeanUtils.copyProperties(QuizDTO, Quiz);
        return Quiz;
    }

}
