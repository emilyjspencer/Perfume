package com.EmilySpencer.perfume.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmilySpencer.perfume.model.Review;
import com.EmilySpencer.perfume.repository.ReviewDao;


@Service
public class ReviewService {

	private static Logger LOGGER = LogManager.getLogger(ReviewService.class);

	@Autowired
	private ReviewDao reviewDao;

	public ReviewService(ReviewDao reviewDao) {
		super();
		this.reviewDao = reviewDao;
	}

	public void create(Review review) {
		String body = review.getBody();
		if (reviewDao.getByBody(body).size() > 0) {
			LOGGER.info("This review is already in the database");
		} else {
			reviewDao.save(review);
		}
	}
	
	public List<Review> retrieveAll() {
		return reviewDao.findAll();
	}
	
	public List<Review> retrieveAllForParticularPerfume(long perfumeId) {
        return reviewDao.getReviewsForPerfume(perfumeId);
	}
}
