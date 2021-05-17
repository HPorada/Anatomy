package com.project.anatomy.service;

import com.project.anatomy.repository.AnswerRepository;
import com.project.anatomy.repository.entity.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerManager {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerManager(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Iterable<Answer> findAll(){
        return answerRepository.findAll();
    }

    public Optional<Answer> findById(Long id){
        return answerRepository.findById(id);
    }
}
