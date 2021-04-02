package com.EmilySpencer.perfume.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.EmilySpencer.perfume.model.Review;

public interface ReviewDao extends JpaRepository<Review, Long> {
	
	List<Review> getByBody(String body);
	
	@Query(value = "Select r.reviewId, r.title, r.body, r.dateOfReview, r.userId, r.perfumeId from Review r where r.perfumeId = :perfumeId", nativeQuery = true)
	List<Review> getReviewsForPerfume(@Param("perfumeId") long perfumeId);
}

