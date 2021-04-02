package com.EmilySpencer.perfume.service;

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

}
