package com.example.quizzes.services;

import com.example.quizzes.dtos.QuestionDto;
import com.example.quizzes.dtos.QuizDto;
import com.example.quizzes.entities.Question;
import com.example.quizzes.entities.Quiz;
import com.example.quizzes.exceptions.QuizNotFoundException;
import com.example.quizzes.mappers.QuestionMapperImpl;
import com.example.quizzes.repositories.QuestionRepository;
import com.example.quizzes.repositories.QuizRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class QuizServiceImpl implements QuizService{
private QuizRepository quizRepository;
    private QuestionMapperImpl questionMapper;
    private QuestionRepository questionRepository;
    @Override
    public List<QuizDto> quizzesDtoList() {
//        return quizRepository.findAll();
        return null;
    }

    @Override
    public QuizDto getQuizDTO(Long quizId) {
//        return quizRepository.findById(quizId);
        return null;
    }

    @Override
    public List<Quiz> quizzesList() {
        List<Quiz> quizzes = quizRepository.findAll();
        return quizzes;
    }

    public Quiz getQuiz(Long quizId) throws QuizNotFoundException {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new QuizNotFoundException("Product not found"));
        return quiz;
    }
    @Override
    public Quiz saveQuiz(Quiz quiz) {
//        log.info("Saving new Product");
        Quiz savedQuiz =quizRepository.save(quiz);
        return savedQuiz;
    }
    @Override
    public List<Question> questionList() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestion(Long questionId) throws QuizNotFoundException {
         Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new QuizNotFoundException("Question not found"));
        return question;
    }

    @Override
    public Question saveQuestion(Question question) {
        Question savedQuestion =questionRepository.save(question);
        return savedQuestion;
    }

    @Override
    public QuestionDto saveQuestionDto(QuestionDto questionDto) {
        log.info("Saving new Question");
        Question question = questionMapper.fromQuestionDTO(questionDto);
        Question savedQuestion =questionRepository.save(question);
        return questionMapper.fromQuestion(savedQuestion);
    }
}
