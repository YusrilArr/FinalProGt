package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.IUserRepo;
import com.example.demo.service.IUserService;


@Service
public class UserService implements IUserService {
	
	@Autowired
	IUserRepo userRepo;

	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.insertUser(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.getAllUser();
	}

	@Override
	public User updateUser(int id, User user) {
		// TODO Auto-generated method stub
		return userRepo.updateUser(id, user);
	}

	@Override
	public User deleteUser(int id) {
		// TODO Auto-generated method stub
		return userRepo.deleteUser(id);
	}

}
