package com.parrot.backendchallenge.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.parrot.backendchallenge.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
