package com.example.springboot_demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springboot_demo.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer>{
	@Query(value="select * from users where name=?1 AND password =?2",nativeQuery=true)
	User findUser(String name,String password);
}
