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
	
	@Test
	void testThatAUserCanBeRetrievedByTheirUsernameAndPassword() {
		User userFromDb = userService.getByUsernameAndPassword("adminemily", "javascript");
		assertTrue(userFromDb.getUserId() > 0);
	}
	
	@Test
	void test_ThatAUserCanBeRetrievedByTheirId() {
		User user = new User("Mary", "Jones", 55, "6 Merton Road", 8765438, "mary", "python", "mary@jones.com", true);
		userService.create(user);
		long userId = user.getUserId();
		User userFromDb = userService.findAUser(userId).get();
		assertEquals(user, userFromDb);
	}
	
	@Test
	void test_ThatAllUsersCanBeRetrieved_FromTheDatabase() {
		int numberOfUsersBeforeCreatingNewUser = userService.retrieveAll().size();
		User user4 = new User("Sam", "Smith", 20, "30 Elizabeth Gardens", 3833837, "sam", "sam3", "sam@smith.com", false);
		userService.create(user4);
		int numberAfterAdding = userService.retrieveAll().size();
		assertNotEquals(numberOfUsersBeforeCreatingNewUser, numberAfterAdding);
	}
	
	@Test
	void test_ThatAUserCanBeDeleted() {
		int numberBeforeDeletion = userService.retrieveAll().size();
		long userIdToDelete = 2;
		userService.delete(userIdToDelete);
		int numberAfterDeletion = userService.retrieveAll().size(); 
		assertNotEquals(numberAfterDeletion, numberBeforeDeletion);
	}
	
	@Test
	void test_ThatACustomerUserMustBe13ToCreateAnAccount() {
		int numberBeforeCreation = userService.retrieveAll().size();
		User user = new User("Laura", "Jones", 12, "14 The Avenue", 3837482, "laurajane", "flower",
				"laura@jane.com, true", true);
		userService.create(user);
		int numberAfterCreationOfInvalidUser = userService.retrieveAll().size();
		assertEquals(numberBeforeCreation, numberAfterCreationOfInvalidUser);
	}




}
