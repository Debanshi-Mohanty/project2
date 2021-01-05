package com.springboot.crudrestfulwebservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.springboot.crudrestfulwebservices.exception.ResourceNotFoundException;
import com.springboot.crudrestfulwebservices.model.User;
import com.springboot.crudrestfulwebservices.repository.UserRepository;

import antlr.collections.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
  @Autowired
  private UserRepository userRepository;
  
  @PostMapping("/users")
  public User createUser(@RequestBody User user) {
	  return userRepository.save(user);
  }
  
  @GetMapping("/users")
  public java.util.List<User> getAllUser(){
	  return userRepository.findAll();
  }
  
  @GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);
	}
  
  @PutMapping("/users/{id}")
  public ResponseEntity <User>  updateuser(@PathVariable(value="id") long userId,@RequestBody User userDetails) throws ResourceNotFoundException {
	  User user = userRepository.findById(userId)
	          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	  user.setName(userDetails.getName());
	  user.setSex(userDetails.getSex());
	  user.setAge(userDetails.getSex());
	  user.setAddress(userDetails.getAddress());
	  userRepository.save(user);
	  return ResponseEntity.ok().body(user);
  }
  
  @DeleteMapping("/users/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId)throws ResourceNotFoundException {
	   userRepository.findById(userId)
	          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
	  userRepository.deleteById(userId);
	  return ResponseEntity.ok().build();
  }
 }
