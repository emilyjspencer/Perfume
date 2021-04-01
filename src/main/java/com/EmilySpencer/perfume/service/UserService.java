package com.EmilySpencer.perfume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmilySpencer.perfume.model.User;
import com.EmilySpencer.perfume.repository.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public void create(User user) {
		userDao.save(user);
	}

	public List<User> retrieveAll() {
		return userDao.findAll();
	}

	public User getByUsernameAndPassword(String username, String password) {
		return userDao.getByUsernameAndPassword(username, password);
	}

}
