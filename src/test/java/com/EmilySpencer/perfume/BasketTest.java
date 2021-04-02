package com.EmilySpencer.perfume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.EmilySpencer.perfume.model.Basket;
import com.EmilySpencer.perfume.service.BasketService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class BasketTest {

	@Autowired
	private BasketService basketService;

	@Test
	void test_ThatABasketCanBeCreated() {
		Basket basket = new Basket();
		basketService.create(basket);
		assertTrue(basket.getBasketId() > 0);
	}

}
