package com.example.user.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;
//@RefreshScope
@RestController
@RequestMapping("/user/db")
public class UserController {


/*	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String userName;
	@Value("${spring.datasource.password}")
	private String password;
	@Autowired
	private DataSource dataSource;
	
	*/



	@Autowired
	private UserRepository userRepository;

	@GetMapping("/api/users")
	public List<User> listofUser(){

		return userRepository.findAll();
	}
	@GetMapping("/api/user/{id}")
	public Optional<User> userById(@PathVariable int id) {
		return userRepository.findById(id);

	}
	@DeleteMapping("/api/deleteuser/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	@PutMapping("api/updateuser/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable int id){
		Optional<User> getUser=userRepository.findById(id);
		if(!getUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		user.setId(id);

		userRepository.save(user);

		return ResponseEntity.ok().build();

	}
	@PostMapping("/api/createusers")
	public ResponseEntity<Object> createUser(@RequestBody User user){
		User saveUser =userRepository.save(user);
		URI loaction=ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}")
				.buildAndExpand(saveUser.getId()).toUri();
		return ResponseEntity.created(loaction).build();
	}



}
