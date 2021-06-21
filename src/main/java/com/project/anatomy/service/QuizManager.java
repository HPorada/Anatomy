package com.project.anatomy.service;

import com.project.anatomy.repository.AnswerRepository;
import com.project.anatomy.repository.QuizRepository;
import com.project.anatomy.repository.entity.Answer;
import com.project.anatomy.repository.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizManager {

    private QuizRepository quizRepository;

    @Autowired
    public QuizManager(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Iterable<Quiz> findAll() {
        return quizRepository.findAll();
    }

    public Optional<Quiz> findById(Long id) {
        return quizRepository.findById(id);
    }

    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public Optional<Quiz> findByName(String name){
        return quizRepository.findByQuizName(name);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillQuizDB(){
        save(new Quiz("Skull", "Bones of the skull", 15, "Skeletal system"));
    }
}
