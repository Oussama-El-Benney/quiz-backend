package com.example.quizzes.mappers;

import com.example.quizzes.dtos.QuestionDto;
import com.example.quizzes.entities.Question;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class QuestionMapperImpl {
  public QuestionDto fromQuestion(Question question) {
    QuestionDto questionDTO = new QuestionDto();
    BeanUtils.copyProperties(question, questionDTO);
    return questionDTO;
  }


  public Question fromQuestionDTO(QuestionDto questionDTO) {
    Question question = new Question();
    BeanUtils.copyProperties(questionDTO, question);
    return question;
  }


}
