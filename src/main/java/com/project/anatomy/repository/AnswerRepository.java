package com.project.anatomy.repository;

import com.project.anatomy.repository.entity.Answer;
import com.project.anatomy.repository.entity.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

    List<Answer> findByQuizId(Long id);

}