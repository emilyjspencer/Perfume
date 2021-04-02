package com.EmilySpencer.perfume;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

}
