package com.project.anatomy.service;

import com.project.anatomy.repository.AnswerRepository;
import com.project.anatomy.repository.FriendsRepository;
import com.project.anatomy.repository.entity.Answer;
import com.project.anatomy.repository.entity.Friends;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FriendsManager {

    private FriendsRepository friendsRepository;

    @Autowired
    public FriendsManager(FriendsRepository friendsRepository) {
        this.friendsRepository = friendsRepository;
    }

    public Iterable<Friends> findAll() {
        return friendsRepository.findAll();
    }

    public Optional<Friends> findById(Long id) {
        return friendsRepository.findById(id);
    }

    public Friends save(Friends friends) {
        return friendsRepository.save(friends);
    }

    public List<Friends> findByFirstId(Long id) {
        return friendsRepository.findByFirstId(id);
    }

    public List<Friends> findBySecondId(Long id) {
        return friendsRepository.findBySecondId(id);
    }
}
