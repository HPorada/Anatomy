package com.project.anatomy.repository;

import com.project.anatomy.repository.entity.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {

    Optional<Quiz> findByQuizName(String name);
}