package com.EmilySpencer.perfume.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmilySpencer.perfume.model.Store;
import com.EmilySpencer.perfume.repository.StoreDao;

@Service
public class StoreService {
	
	@Autowired
	private StoreDao storeDao;

	public void create(Store store) {
		storeDao.save(store);
	}

	public Optional<Store> findAStore(long storeId) {
			return storeDao.findById(storeId);
	}

	public List<Store> retrieveAll() {
		return storeDao.findAll();
	}

	public void delete(long storeId) {
		storeDao.deleteById(storeId);	
	}
}
