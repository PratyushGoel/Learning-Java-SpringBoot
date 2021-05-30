package com.example.Notify;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepositorySpring extends CrudRepository<User, String> {

    List<User> findAll();

}
