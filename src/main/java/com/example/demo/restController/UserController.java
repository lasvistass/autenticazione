package com.example.demo.restController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping(value="/api/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	@GetMapping(value="/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Optional<User> getById(@PathVariable(required = true) Integer id){
		return userRepository.findById(id);
	}
	
	@PostMapping(value="/save")
	public User saveUser(@RequestBody User user){
		return userRepository.save(user);
	}
}
