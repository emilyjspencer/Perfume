package com.EmilySpencer.perfume.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.EmilySpencer.perfume.model.Brand;
import com.EmilySpencer.perfume.service.BrandService;

@Controller
public class BrandController {

	private static final Logger LOGGER = LogManager.getLogger(BrandController.class);

	@Autowired
	private BrandService brandService;

	@GetMapping("/AllBrands")
	public ModelAndView allBrands() {
		return new ModelAndView("WEB-INF/allBrands.jsp", "allBrands", brandService.retrieveAll());
	}

	@GetMapping("/AllBrandsCustomer")
	public ModelAndView allBrandsCustomer() {
		return new ModelAndView("WEB-INF/allBrandsCustomer.jsp", "allBrandsCustomer", brandService.retrieveAll());
	}

	@GetMapping("/AddBrand")
	public String addBrand() {
		return "WEB-INF/addBrand.jsp";
	}

	@PostMapping("/AddBrandSubmit")
	public ModelAndView addAuthorSubmit(Brand brand, ModelMap model) {
		brandService.create(brand);
		LOGGER.info("Brand " + brand + "has been added");
		model.addAttribute("message", "Brand" + brand.getName() + "has been added");
		return new ModelAndView("WEB-INF/allBrands.jsp", "allBrands", brandService.retrieveAll());
	}

}