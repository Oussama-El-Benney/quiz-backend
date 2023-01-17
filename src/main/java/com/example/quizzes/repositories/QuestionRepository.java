package com.example.quizzes.repositories;

import com.example.quizzes.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface QuestionRepository extends JpaRepository<Question,Long> {

//        List<Quiz>findAll
 }
