package com.example.quizzes.web;

import com.example.quizzes.dtos.QuestionDto;
import com.example.quizzes.dtos.QuizDto;
import com.example.quizzes.entities.Question;
import com.example.quizzes.entities.Quiz;
import com.example.quizzes.exceptions.QuizNotFoundException;
import com.example.quizzes.services.QuizService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class QuizRestController {
    private QuizService quizService;

    @GetMapping("/quizzes")
    public List<Quiz> quizzesList() throws QuizNotFoundException{
        return quizService.quizzesList();
    }
    @GetMapping("/quizzesdto")
    public List<QuizDto> quizzesDtoList() throws QuizNotFoundException{
        return quizService.quizzesDtoList();
    }

    @GetMapping("/quizzes/{id}")
    public Quiz getQuiz(@PathVariable(name = "id") Long quizId) throws QuizNotFoundException {
        return quizService.getQuiz(quizId);
    }

    @PostMapping("/add-quiz")
    public Quiz saveQuiz(@RequestBody QuizDto quizDto) {
        return quizService.saveQuiz(quizDto);
    }

    @GetMapping("/questions")
    public List<Question> questions() {
        return quizService.questionList();
    }

    @GetMapping("/questions/{id}")
    public Question getQuestion(@PathVariable(name = "id") Long questionId) throws QuizNotFoundException {
        return quizService.getQuestion(questionId);
    }

    @PostMapping("/add-question")
    public Question saveQuestion(@RequestBody QuestionDto questionDto) {
        return quizService.saveQuestion(questionDto);
    }

    @PostMapping("/add-question-to-quiz")
    public QuestionDto addQuestionToQuiz(@RequestBody QuestionDto questionDto) throws QuizNotFoundException {
        return quizService.addQuestionToQuiz(questionDto);
    }
}
