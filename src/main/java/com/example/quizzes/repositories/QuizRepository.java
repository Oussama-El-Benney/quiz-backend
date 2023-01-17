package com.example.quizzes.repositories;

import com.example.quizzes.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @RestResource(path = "/byName")
    List<Quiz> findByName(@Param("n") String name);
}
