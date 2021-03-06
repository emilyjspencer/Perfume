package com.EmilySpencer.perfume.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmilySpencer.perfume.model.User;
import com.EmilySpencer.perfume.repository.UserDao;

@Service
public class UserService {

	private final static Logger LOGGER = LogManager.getLogger(UserService.class);

	@Autowired
	private UserDao userDao;

	public void create(User user) {
		createUser: {
			if (user.getAge() < 13) {
				LOGGER.error("Unable to create account. Users users must be over 13 and over");
				break createUser;
			}
			int cardNumber = user.getCardNumber();
			String number = String.valueOf(cardNumber);
			char[] digits1 = number.toCharArray();
			if (digits1.length != 7) {
				LOGGER.error("Unable to create account. Invalid card number");
				break createUser;
			}
			String username = user.getUsername();
			if (userDao.getByUsername(username).size() > 0) {
				LOGGER.error("Username is taken. Please enter a different username");
				break createUser;
			}
			userDao.save(user);
		}
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

	public boolean checkIfAdmin(User user) {
		if (user.isCustomerUser()) {
			return false;
		} else {
			return true;
		}
	}

}
