package com.example.quizzes.repositories;

import com.example.quizzes.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface QuestionRepository extends JpaRepository<Question,Long> {
 List<Question> findAllByQuizFather_Id(Long quizFather_Id);
//        List<Quiz>findAll
 }
