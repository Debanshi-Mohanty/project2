package com.springboot.crudrestfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crudrestfulwebservices.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
