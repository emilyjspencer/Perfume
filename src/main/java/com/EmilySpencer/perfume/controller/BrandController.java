package com.EmilySpencer.perfume.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.EmilySpencer.perfume.service.BrandService;


@Controller
public class BrandController {

	@Autowired
	private BrandService brandService;

	private static final Logger LOGGER = LogManager.getLogger(BrandController.class);

	@GetMapping("/AllBrands")
	public ModelAndView allBrands() {
		return new ModelAndView("WEB-INF/allBrands.jsp", "allBrands", brandService.retrieveAll());
	}

	@GetMapping("/AllBrandsCustomer")
	public ModelAndView allBrandsCustomer() {
		return new ModelAndView("WEB-INF/allBrandsCustomer.jsp", "allBrandsCustomer", brandService.retrieveAll());
	}
	
}