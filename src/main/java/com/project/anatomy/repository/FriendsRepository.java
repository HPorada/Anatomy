package com.project.anatomy.repository;

import com.project.anatomy.repository.entity.Friends;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsRepository extends CrudRepository<Friends, Long> {

}