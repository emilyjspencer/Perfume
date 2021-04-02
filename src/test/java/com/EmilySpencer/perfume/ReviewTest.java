package com.EmilySpencer.perfume;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.EmilySpencer.perfume.model.Review;
import com.EmilySpencer.perfume.service.PerfumeService;
import com.EmilySpencer.perfume.service.ReviewService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ReviewTest {

	@Autowired
	ReviewService reviewService;

	@Autowired
	PerfumeService perfumeService;

	@Test
	void test_ThatAReviewCanBeCreated() {
		Review review = new Review();
		reviewService.create(review);
		assertTrue(review.getReviewId() > 0);
	}
	
	@Test
	void test_ThatAllReviewsCanBeRetrieved() {
		int numberBeforeAdding = reviewService.retrieveAll().size();
		Review review = new Review();
	    reviewService.create(review);
		Review review2 = new Review();
		reviewService.create(review2);
		int numberAfterAdding = reviewService.retrieveAll().size();
		assertNotEquals(numberAfterAdding, numberBeforeAdding);
	}
	
	@Test
	void test_ThatAllReviewsForAParticularPerfumeCanBeRetrieved() {
		List<Review> reviews = reviewService.retrieveAllForParticularPerfume(1);
		System.out.println(reviews);
		assertTrue(reviews.size() == 3);
	}

}
