package com.example.springboot_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot_demo.model.User;
import com.example.springboot_demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	

	public List<User> createUsers(List<User> users){
		return userRepository.saveAll(users);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(int id)
	{
		return userRepository.findById(id).orElse(null);
	}
	
	public User updateUser(User user) {
		Optional<User> optionalUser = userRepository.findById(user.getId());
	    
		if(optionalUser.isPresent()) {
			User oldUser = optionalUser.get();
			oldUser.setName(user.getName());	
			oldUser.setAddress(user.getAddress());
			userRepository.save(oldUser);
			
		}
		else {
			return newUser();
		}
		User oldUser=null;
		return oldUser;
		
	}
	
	private User newUser() {
		// TODO Auto-generated method stub
		return null;
	}


	public String deleteUserById(int id) {
		 userRepository.deleteById(id);
		 return "users deleted";
	}


	public User findUser(String name, String password) {
		return userRepository.findUser(name, password);
	};
	
	

}
