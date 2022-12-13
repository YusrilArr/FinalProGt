package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.User;

public interface IUserRepo {
	public User insertUser(User user);
	public List<User> getAllUser();
	public User updateUser(int id, User user);
	public User deleteUser(int id);
	

}
