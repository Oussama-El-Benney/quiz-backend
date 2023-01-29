package com.example.quizzes.mappers;

import com.example.quizzes.dtos.QuestionDto;
import com.example.quizzes.entities.Question;
import com.example.quizzes.entities.Quiz;
import com.example.quizzes.exceptions.QuizNotFoundException;
import com.example.quizzes.repositories.QuizRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class QuestionMapperImpl {
  private QuizMapperImpl quizMapper;
  private QuizRepository quizRepository;
  public QuestionDto fromQuestion(Question question) {
    QuestionDto questionDTO = new QuestionDto();
    BeanUtils.copyProperties(question, questionDTO);
    return questionDTO;
  }


  public Question fromQuestionDTO(QuestionDto questionDTO) throws QuizNotFoundException {
    Question question = new Question();
    BeanUtils.copyProperties(questionDTO, question);

//    Quiz quiz = quizRepository.findById(questionDTO.getQuizFatherId().longValue())
//            .orElseThrow(() -> new QuizNotFoundException("Quiz not found"));
//    question.setQuizFather(quiz);
//    quiz.getQuestions().add(question);
    return question;
  }


}
