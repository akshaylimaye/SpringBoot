package com.example.springBoot28Min.Controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.example.springBoot28Min.DAO.UserDao;
import com.example.springBoot28Min.users.Users;

@RestController
public class UserController {
	
	@Autowired
	private UserDao userDao;
	
	
	@PostMapping(path = "/users")
	public ResponseEntity<Users> addUser(@Valid @RequestBody Users user) {
		userDao.addUsers(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path = "/users")
	public List<Users> getUsers() {
		return userDao.getUsers();
	}
	
	@GetMapping(path="users/{id}")
	public Users getUsersById(@PathVariable int id) {
		Users user = userDao.getUserById(id);
		return user;
		
	}	
	@DeleteMapping(path="users/{id}")
	public void deletById(@PathVariable int id) {
		userDao.deleteById(id);
	}
}
