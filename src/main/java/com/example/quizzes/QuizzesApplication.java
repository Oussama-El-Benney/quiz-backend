package com.example.quizzes;

import com.example.quizzes.entities.Question;
import com.example.quizzes.entities.Quiz;
import com.example.quizzes.exceptions.QuizNotFoundException;
import com.example.quizzes.repositories.QuestionRepository;
import com.example.quizzes.repositories.QuizRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class QuizzesApplication {

    @RequestMapping("/")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping("/s")
    public String save() {
        return "sss!";
    }

    @RequestMapping("/hu")
    public String shit() {
        return "hahahahha!";
    }

    public static void main(String[] args) {
        SpringApplication.run(QuizzesApplication.class, args);
    }

    @Bean
    CommandLineRunner start(QuizRepository quizRepository,
                            QuestionRepository questionRepository) {
        return args -> {
            Quiz quiz = new Quiz();
            quiz.setName("Quizo");
            quiz.setDescription("this angular test is the hardest to ever witness hihiwwww");
            quizRepository.save(quiz);
//
//
            Question question=new Question();

            question.setQuestion("How to get the best quiz App?");
            List<String> choices = new ArrayList<>();
            choices.add("first choice");
            choices.add("seconde choice");
            choices.add("third choice");
            choices.add("fouth choice");
            question.setChoices(choices);
            question.setCorrectChoice("seconde choice");
            question.setQuizFather(quizRepository.findById(1L)
                    .orElseThrow(() -> new QuizNotFoundException("Quiz not found")));

            questionRepository.save(question);
            //
//            List<Question> questions = new ArrayList<>();
//            questions.add(question);
        };
    }
}
