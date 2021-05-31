package com.project.anatomy.service;

import com.project.anatomy.repository.AnswerRepository;
import com.project.anatomy.repository.entity.Answer;
import com.project.anatomy.repository.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
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

    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillCustomersDB(){
        save(new Answer("zęby", "dentes", "teeth", "1.png"));
        save(new Answer("żuchwa", "mandibular", "mandible", "2.png"));
        save(new Answer("szczęka", "maxilla", "maxilla", "3.png"));
        save(new Answer("kość sitowa", "os ethmoidale", "ethmoid bone", "4.png"));
        save(new Answer("kość nosowa", "os nasale", "nasal bone", "5.png"));
        save(new Answer("kość klinowa", "os sphenoidale", "sphenoid bone", "6.png"));
        save(new Answer("kość jarzmowa", "os zygomaticum", "zygomatic bone", "7.png"));
        save(new Answer("kość czołowa", "os frontale", "frontal bone", "8.png"));
        save(new Answer("kość skroniowa", "os temporale", "temporal bone", "9.png"));
        save(new Answer("kość potyliczna", "os occipital", "occipital bone", "10.png"));
        save(new Answer("kość ciemieniowa", "os parietale", "parietal bone", "11.png"));
        save(new Answer("siekacze", "dentes incisive", "incisors", "12.png"));
        save(new Answer("kły", "dentes canini", "canines", "13.png"));
        save(new Answer("przedtrzonowce", "dentes premolars", "premolars", "14.png"));
        save(new Answer("trzonowce", "dentes molars", "molars", "15.png"));
    }
}
