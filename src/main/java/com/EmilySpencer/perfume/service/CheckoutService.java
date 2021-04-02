package com.EmilySpencer.perfume.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmilySpencer.perfume.model.Checkout;
import com.EmilySpencer.perfume.repository.CheckoutDao;

@Service
public class CheckoutService {

	@Autowired
	private CheckoutDao checkoutDao;

	public CheckoutService(CheckoutDao checkoutDao) {
		super();
		this.checkoutDao = checkoutDao;
	}

	public void create(Checkout checkout) {
		checkoutDao.save(checkout);
	}
	
	public Optional<Checkout> findACheckout(long checkoutId) {
		return checkoutDao.findById(checkoutId);
	}

	public List<Checkout> retrieveAll() {
		return checkoutDao.findAll();
	}
}
