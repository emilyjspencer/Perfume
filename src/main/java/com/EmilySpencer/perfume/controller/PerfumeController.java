package com.EmilySpencer.perfume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.EmilySpencer.perfume.service.PerfumeService;

@Controller
public class PerfumeController {
	
	@Autowired
	private PerfumeService perfumeService;

	@GetMapping("/AllPerfumes")
	public ModelAndView allPerfumes() {
		return new ModelAndView("WEB-INF/allPerfumes.jsp", "allPerfumes", perfumeService.retrieveAll());
	}

	@GetMapping("/AllPerfumesCustomer")
	public ModelAndView allPerfumesCustomer() {
		return new ModelAndView("WEB-INF/allPerfumesCustomer.jsp", "allPerfumes", perfumeService.retrieveAll());
	}

}
