package com.EmilySpencer.perfume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EmilySpencer.perfume.model.Review;

public interface ReviewDao extends JpaRepository<Review, Long> {
	
	List<Review> getByBody(String body);
}

