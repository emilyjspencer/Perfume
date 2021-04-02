package com.EmilySpencer.perfume;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.EmilySpencer.perfume.model.Basket;
import com.EmilySpencer.perfume.model.Checkout;
import com.EmilySpencer.perfume.service.BasketService;
import com.EmilySpencer.perfume.service.CheckoutService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CheckoutTest {

	@Autowired
	private BasketService basketService;

	@Autowired
	private CheckoutService checkoutService;

	@Test
	void test_ThatACheckoutCanBeCreated() {
		Basket basket = basketService.findABasket(3).get();
		Checkout checkout = new Checkout(basket);
		checkoutService.create(checkout);
		assertTrue(checkout.getCheckoutId() > 0);
	}
}
