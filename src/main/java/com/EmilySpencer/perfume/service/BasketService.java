package com.EmilySpencer.perfume.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmilySpencer.perfume.model.Basket;
import com.EmilySpencer.perfume.repository.BasketDao;

@Service
public class BasketService {	

	@Autowired
	private BasketDao basketDao;

	public BasketService(BasketDao basketDao) {
		super();
		this.basketDao = basketDao;
	}

	public void create(Basket basket) {
		basketDao.save(basket);
	}
	
	public Optional<Basket> findABasket(long basketId) {
		return basketDao.findById(basketId);
	}
	
	public List<Basket> retrieveAll() {
		return basketDao.findAll();
	}
	
	public void update(Basket basket) {
		basketDao.save(basket);
	}
	
	public void delete(long basketId) {
		basketDao.deleteById(basketId);
	}
}
