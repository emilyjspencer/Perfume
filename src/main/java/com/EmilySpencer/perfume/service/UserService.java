package com.EmilySpencer.perfume.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmilySpencer.perfume.model.User;
import com.EmilySpencer.perfume.repository.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Service
public class UserService {
	
	private final static Logger LOGGER = LogManager.getLogger(UserService.class);
	
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

	public Optional<User> findAUser(long userId) {
		Optional<User> user = userDao.findById(userId);
		if (!user.isPresent()) {
			LOGGER.info("That user does not exist");
		}
		return user;
	}

	public boolean delete(long userId) {
		if (findAUser(userId).isPresent()) {
			userDao.deleteById(userId);		
			return true;
		}
		return false;
	}




}
