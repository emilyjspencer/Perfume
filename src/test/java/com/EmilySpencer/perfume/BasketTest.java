package com.EmilySpencer.perfume;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.EmilySpencer.perfume.model.Basket;
import com.EmilySpencer.perfume.model.Perfume;
import com.EmilySpencer.perfume.model.User;
import com.EmilySpencer.perfume.service.BasketService;
import com.EmilySpencer.perfume.service.PerfumeService;
import com.EmilySpencer.perfume.service.UserService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class BasketTest {

	@Autowired
	private BasketService basketService;
	
	@Autowired
	private PerfumeService perfumeService;
	
	@Autowired
	private UserService userService;
	
	List<Basket> basketList = new ArrayList<Basket>();
	
	List<Perfume> perfumesList = new ArrayList<Perfume>();

	@Test
	void test_ThatABasketCanBeCreated() {
		Basket basket = new Basket();
		basketService.create(basket);
		assertTrue(basket.getBasketId() > 0);
	}
	
	@Test
	void test_ThatABasketCanBeRetrievedUsingTheId() {
		Basket basketFromDb = basketService.findABasket(1).get();
		assertEquals(basketFromDb.getBasketId(), 1);
	}
	
	@Test
	void test_ThatAllBasketsCanBeRetrieved() {
		basketList = basketService.retrieveAll();
		assertTrue(basketList.size() > 0);
	}
	
	@Test
	void test_ThatPerfumesCanBeAddedToBasket() {
		Basket basketToUpdate = basketService.findABasket(2).get();
		List<Perfume> perfumesBeforeUpdate = basketToUpdate.getPerfumes();
		Perfume perfume = perfumeService.retrieveOne(5).get();
		perfumesList.add(perfume);
		basketToUpdate.setPerfumes(perfumesList);
		basketService.update(basketToUpdate);
		Basket updatedBasket = basketService.findABasket(2).get();
		List<Perfume> perfumesAfterUpdate = updatedBasket.getPerfumes();
		assertNotEquals(perfumesBeforeUpdate, perfumesAfterUpdate);
	}
	
	@Test
	void testThatABasketCanBeDeleted() {
		Basket basket = new Basket();
		basketService.create(basket);
		long basketId = basketService.findABasket(basket.getBasketId()).get().getBasketId();
		int numberBeforeDelete = basketService.retrieveAll().size();
		basketService.delete(basketId);
		int numAfterDeleting = basketService.retrieveAll().size();
		assertNotEquals(numberBeforeDelete, numAfterDeleting);
	}
	
	@Test
	void test_ThatGetPerfumesReturnsNoPerfumesIfNoPerfumesHaveBeenAddedToBasket() {
		Basket basket = new Basket();
		basketService.create(basket);
		List<Perfume> perfumes = basketService.getBasketsPerfumes(basket);
		assertEquals(0, perfumes.size());
	}
	
	@Test
	void test_ThatGetBasketsPerfumes_CalledOnBasket3Returns4Perfumes() {
		Basket basketRetrievedFromDb = basketService.findABasket(3).get();
		List<Perfume> perfumes = basketService.getBasketsPerfumes(basketRetrievedFromDb);
		assertEquals(4, perfumes.size());
	}
	
	@Test
	void test_ThatABasketCanBeFoundByUser() {
		User userRetrievedFromDb = userService.findAUser(3).get();
		Basket basketFromDb = basketService.getByUser(userRetrievedFromDb);
		assertTrue(basketFromDb.getBasketId() > 0);
	}


}
