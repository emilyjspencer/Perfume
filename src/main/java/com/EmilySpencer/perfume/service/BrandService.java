package com.EmilySpencer.perfume.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmilySpencer.perfume.model.Brand;
import com.EmilySpencer.perfume.repository.BrandDao;

@Service
public class BrandService {

	@Autowired
	private BrandDao brandDao;

	public BrandService(BrandDao brandDao) {
		super();
		this.brandDao = brandDao;
	}

	public void create(Brand brand) {
		brandDao.save(brand);
	}

	public List<Brand> retrieveAll() {
		return brandDao.findAll();
	}

	public Optional<Brand> findABrand(long brandId) {
		return brandDao.findById(brandId);
	}

	public void update(Brand brand) {
		brandDao.save(brand);
	}

	public void delete(long brandId) {
		brandDao.deleteById(brandId);
	}

}