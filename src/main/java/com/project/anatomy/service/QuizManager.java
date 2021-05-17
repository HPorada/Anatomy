package com.project.anatomy.service;

import com.project.anatomy.repository.AnswerRepository;
import com.project.anatomy.repository.QuizRepository;
import com.project.anatomy.repository.entity.Answer;
import com.project.anatomy.repository.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizManager {

    private QuizRepository quizRepository;

    @Autowired
    public QuizManager(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Iterable<Quiz> findAll(){
        return quizRepository.findAll();
    }

    public Optional<Quiz> findById(Long id){
        return quizRepository.findById(id);
    }
}
