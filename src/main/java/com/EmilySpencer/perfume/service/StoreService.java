package com.EmilySpencer.perfume.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmilySpencer.perfume.model.Store;
import com.EmilySpencer.perfume.model.User;
import com.EmilySpencer.perfume.repository.StoreDao;

@Service
public class StoreService {
	
	@Autowired
	private StoreDao storeDao;

	public void create(Store store) {
		storeDao.save(store);
	}
}
