package com.project.anatomy.service;

import com.project.anatomy.repository.AnswerRepository;
import com.project.anatomy.repository.QuestionRepository;
import com.project.anatomy.repository.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionManager {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionManager(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Iterable<Question> findAll(){
        return questionRepository.findAll();
    }

    public Optional<Question> findById(Long id){
        return questionRepository.findById(id);
    }
}
