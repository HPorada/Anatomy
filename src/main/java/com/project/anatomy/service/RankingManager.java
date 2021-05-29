package com.project.anatomy.service;

import com.project.anatomy.repository.FriendsRepository;
import com.project.anatomy.repository.RankingRepository;
import com.project.anatomy.repository.entity.Friends;
import com.project.anatomy.repository.entity.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RankingManager {

    private RankingRepository rankingRepository;

    @Autowired
    public RankingManager(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    public Iterable<Ranking> findAll(){
        return rankingRepository.findAll();
    }

    public Optional<Ranking> findById(Long id){
        return rankingRepository.findById(id);
    }
}
