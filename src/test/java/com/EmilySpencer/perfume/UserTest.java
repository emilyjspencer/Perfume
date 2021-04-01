package com.EmilySpencer.perfume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.EmilySpencer.perfume.model.User;
import com.EmilySpencer.perfume.service.UserService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class UserTest {

	@Autowired
	private UserService userService;
	
	
	@Test
	void testThatAUserCanBeCreated() {
		int numberBeforeCreation = userService.retrieveAll().size();
		User user = new User("Laura", "Jones", 12, "14 The Avenue", 3837482, "laurajane", "flower",
				"laura@jane.com, true", true);
		userService.create(user);
		int numberAfterCreationOfInvalidUser = userService.retrieveAll().size();
		assertNotEquals(numberBeforeCreation, numberAfterCreationOfInvalidUser);
	}

}
