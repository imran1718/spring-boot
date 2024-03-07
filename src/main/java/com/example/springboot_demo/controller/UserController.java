package com.example.springboot_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_demo.model.User;
import com.example.springboot_demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PostMapping("/addUsers")
	public List<User> addUsers(@RequestBody List<User> users) {
		return userService.createUsers(users);
	}
	
	@GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@PathVariable int id) {
		return userService.updateUser(addUser(null));
	}
	
	@DeleteMapping("/deleteUser")
	public String deleteUserById(@PathVariable int id) {
		return "users deleted";
	}
	
	@GetMapping("/login/{name}/{password}")
	public ResponseEntity<String> getUserById(@PathVariable String name,@PathVariable String password) {
		User user= userService.findUser(name,password);
		if(user != null) {
			return ResponseEntity.status(HttpStatus.OK)
					.body("Login Successfull");			
		}else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN)
					.body("Login Failed");			
		}
	}
	
}
