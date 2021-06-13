package com.project.anatomy.service;

import com.project.anatomy.repository.AnswerRepository;
import com.project.anatomy.repository.UserRepository;
import com.project.anatomy.repository.entity.Answer;
import com.project.anatomy.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManager {

    private UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public User findByLogin(String login){ return userRepository.findByLogin(login); }

    public void updatePoints(String login, int points) {
        User user = userRepository.findByLogin(login);
        user.setPoints(points);
        userRepository.save(user);
    }
}
