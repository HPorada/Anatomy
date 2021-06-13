package com.project.anatomy.service;

import com.project.anatomy.repository.AnswerRepository;
import com.project.anatomy.repository.entity.Answer;
import com.project.anatomy.repository.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    public List<Answer> findByQuizId(Long id) {return answerRepository.findByQuizId(id);}

    @EventListener(ApplicationReadyEvent.class)
    public void fillAnswersDB(){
        save(new Answer("zęby", "dentes", "teeth", "1.png", 16L));
        save(new Answer("żuchwa", "mandibular", "mandible", "2.png",16L ));
        save(new Answer("szczęka", "maxilla", "maxilla", "3.png",16L));
        save(new Answer("kość sitowa", "os ethmoidale", "ethmoid bone", "4.png",16L));
        save(new Answer("kość nosowa", "os nasale", "nasal bone", "5.png",16L));
        save(new Answer("kość klinowa", "os sphenoidale", "sphenoid bone", "6.png",16L));
        save(new Answer("kość jarzmowa", "os zygomaticum", "zygomatic bone", "7.png",16L));
        save(new Answer("kość czołowa", "os frontale", "frontal bone", "8.png",16L));
        save(new Answer("kość skroniowa", "os temporale", "temporal bone", "9.png",16L));
        save(new Answer("kość potyliczna", "os occipital", "occipital bone", "10.png",16L));
        save(new Answer("kość ciemieniowa", "os parietale", "parietal bone", "11.png",16L));
        save(new Answer("siekacze", "dentes incisive", "incisors", "12.png",16L));
        save(new Answer("kły", "dentes canini", "canines", "13.png",16L));
        save(new Answer("przedtrzonowce", "dentes premolars", "premolars", "14.png",16L));
        save(new Answer("trzonowce", "dentes molars", "molars", "15.png",16L));
    }
}
