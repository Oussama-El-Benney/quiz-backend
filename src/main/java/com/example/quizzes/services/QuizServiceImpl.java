package com.example.quizzes.services;

import com.example.quizzes.dtos.QuestionDto;
import com.example.quizzes.dtos.QuizDto;
import com.example.quizzes.entities.Question;
import com.example.quizzes.entities.Quiz;
import com.example.quizzes.exceptions.QuizNotFoundException;
import com.example.quizzes.mappers.QuestionMapperImpl;
import com.example.quizzes.mappers.QuizMapperImpl;
import com.example.quizzes.repositories.QuestionRepository;
import com.example.quizzes.repositories.QuizRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class QuizServiceImpl implements QuizService{
private QuizRepository quizRepository;
    private QuestionMapperImpl questionMapper;
    private QuizMapperImpl quizMapper;
    private QuestionRepository questionRepository;
    @Override
    public List<QuizDto> quizzesDtoList() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<QuizDto> quizDtoList = quizzes.stream().map(quiz-> quizMapper.fromQuiz(quiz)).collect(Collectors.toList());
        return quizDtoList;
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
        quiz.getQuestions();
        return quiz;
    }
    @Override
    public Quiz saveQuiz(QuizDto quizDto) {
//        log.info("Saving new Product");
       Quiz quiz =quizMapper.fromQuizDTO(quizDto);
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
    public QuestionDto saveQuestionDto(QuestionDto questionDto) throws QuizNotFoundException {
        log.info("Saving new Question");
        Question question = questionMapper.fromQuestionDTO(questionDto);
        Question savedQuestion =questionRepository.save(question);
        return questionMapper.fromQuestion(savedQuestion);
    }
    @Override
    public QuestionDto addQuestionToQuiz(QuestionDto questionDto) throws QuizNotFoundException {
        log.info("adding new Question to quiz");
        Question question = questionMapper.fromQuestionDTO(questionDto);
        Quiz quiz = quizRepository.findById(questionDto.getQuizFatherId().longValue())
                .orElseThrow(() -> new QuizNotFoundException("Quiz not found"));
        question.setQuizFather(quiz);
//quiz.getQuestions().add(question);
Question savedQuestion =questionRepository.save(question);

        return questionMapper.fromQuestion(savedQuestion);
    }

    @Override
    public List<QuestionDto> getQuizQuestions(Long quizId) {
        List<Question> questions = this.questionRepository.findAllByQuizFather_Id(quizId);
        List<QuestionDto> questionsDto =   questions.stream().map(question-> questionMapper.fromQuestion(question)).collect(Collectors.toList());
        return questionsDto;
    }
}
