package com.EmilySpencer.perfume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.EmilySpencer.perfume.service.ReviewService;

@Controller
public class ReviewsPerPerfumeController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/ReviewsPerPerfume/{perfumeId}")
	public ModelAndView ReviewsPerPerfume(@PathVariable("perfumeId") Long perfumeId, Model model) {
		return new ModelAndView("../WEB-INF/Review.jsp", "review",
				reviewService.retrieveAllForParticularPerfume(perfumeId));
	}

}
