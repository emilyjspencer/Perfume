package com.EmilySpencer.perfume;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
	
	List<Checkout> checkoutList = new ArrayList<Checkout>();

	@Test
	void test_ThatACheckoutCanBeCreated() {
		Basket basket = basketService.findABasket(3).get();
		Checkout checkout = new Checkout(basket);
		checkoutService.create(checkout);
		assertTrue(checkout.getCheckoutId() > 0);
	}
	
	@Test
	void test_ThatACheckoutCanBeRetrievedUsingId() {
		Checkout checkout = checkoutService.findACheckout(3).get();
		assertEquals(3, checkout.getCheckoutId());
	}

	@Test
	void test_ThatAllCheckoutsCanBeRetrieved() {
		checkoutList = checkoutService.retrieveAll();
		assertTrue(checkoutList.size() > 0);
	}
	
	@Test
	void test_ThatACheckoutCanBeDeleted() {
		int numberBeforeDeleting = checkoutService.retrieveAll().size();
		Checkout checkoutToDelete = checkoutService.findACheckout(4).get();
		long checkoutId = checkoutToDelete.getCheckoutId();
		checkoutService.delete(checkoutId);
		int numberAfterDeleting = checkoutService.retrieveAll().size();
		assertNotEquals(numberBeforeDeleting, numberAfterDeleting);
	}
	
	@Test
	void test_ThatACheckoutCanBeUpdated() {
		Checkout checkoutToUpdate = checkoutService.findACheckout(1).get();
		Basket basketBeforeUpdating = checkoutToUpdate.getBasket();
		checkoutToUpdate.setBasket(basketService.findABasket(1).get());
		checkoutService.update(checkoutToUpdate);
		Checkout updatedCheckout = checkoutService.findACheckout(1).get();
		Basket basketAfterUpdating = updatedCheckout.getBasket();
		assertNotEquals(basketBeforeUpdating, basketAfterUpdating);
	}
}
