package com.project.anatomy.repository;

import com.project.anatomy.repository.entity.Answer;
import com.project.anatomy.repository.entity.Friends;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendsRepository extends CrudRepository<Friends, Long> {

    List<Friends> findByFirstId(Long id);

    List<Friends> findBySecondId(Long id);

}