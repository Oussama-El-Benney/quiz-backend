package com.example.quizzes.services;

import com.example.quizzes.dtos.AnswerDto;
import com.example.quizzes.dtos.QuestionDto;
import com.example.quizzes.dtos.QuizDto;
import com.example.quizzes.entities.Question;
import com.example.quizzes.entities.Quiz;
import com.example.quizzes.exceptions.QuizNotFoundException;

import java.util.List;

public interface QuizService {
    List<QuizDto> quizzesDtoList();
    QuizDto getQuizDTO(Long quizId);
    List<Quiz> quizzesList();
    Quiz getQuiz(Long quizId) throws QuizNotFoundException;
    Quiz saveQuiz(QuizDto quizDto);
    List<Question> questionList();
    Question getQuestion(Long questionId) throws QuizNotFoundException;
    Question saveQuestion(Question question);
    QuestionDto saveQuestionDto(QuestionDto questionDto) throws QuizNotFoundException;

    QuestionDto addQuestionToQuiz(QuestionDto questionDto) throws QuizNotFoundException;

    List<QuestionDto> getQuizQuestions(Long quizId);

    boolean verifyUserAnswer(AnswerDto answerDto) throws QuizNotFoundException;
}
