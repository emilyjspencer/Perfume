package com.EmilySpencer.perfume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmilySpencer.perfume.model.Brand;

public interface BrandDao extends JpaRepository<Brand, Long> {
	
}
