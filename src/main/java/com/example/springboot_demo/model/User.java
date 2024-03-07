package com.example.springboot_demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="password")
	private String password;
	@Column(name="address")
	private String address;
	
    public User() {
    	
    }
	public User(int id,String name, String address) {
		this.id=id;
		this.name=name;
		this.address=address;
	}
	public User(String name,String address) {
		this.name=name;
		this.address=address;
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
