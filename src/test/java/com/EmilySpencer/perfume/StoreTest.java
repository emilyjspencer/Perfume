package com.EmilySpencer.perfume;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.EmilySpencer.perfume.model.Store;
import com.EmilySpencer.perfume.service.StoreService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class StoreTest {

	@Autowired
	private StoreService storeService;

	@Test
	void test_ThatAStoreCanBeCreated() {
		Store store = new Store();
		storeService.create(store);
		assertTrue(store.getStoreId() > 0);
	}

	@Test
	void test_ThatAStoreCanBeRetrievedById() {
		Store storeFromDb = storeService.findAStore(3).get();
		assertEquals(3, storeFromDb.getStoreId());
	}

	@Test
	void testThatAllStoresCanBeRetrieved() {
		int numberOfStoresBefore = storeService.retrieveAll().size();
		Store store = new Store("Perfect Perfumes", "Glasgow City Center", 4859372);
		storeService.create(store);
		int numberOfStoresAfter = storeService.retrieveAll().size();
		assertNotEquals(numberOfStoresAfter, numberOfStoresBefore);

	}

}
