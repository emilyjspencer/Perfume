package com.EmilySpencer.perfume.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/EditBrand/{brandId}")
	public ModelAndView editBrand(@PathVariable("brandId") Long brandId, Model model) {
		return new ModelAndView("../WEB-INF/editBrand.jsp", "brand", brandService.findABrand(brandId));
	}

	@PostMapping("/EditBrandSubmit")
	public ModelAndView editBrandSubmit(Brand brand, ModelMap model) {
		brandService.update(brand);
		return new ModelAndView("forward://WEB-INF/allBrands.jsp", "allBrands", brandService.retrieveAll());
	}

	@PostMapping(value = "/EditBrandSubmit", params = { "Delete=Delete" })
	public ModelAndView editBrandSubmit(Brand brand, BindingResult bindingResult, ModelMap model, Long brandId) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "this brand still has perfumes in the stores");
			return new ModelAndView("WEB-INF/editBrand.jsp");
		}
		brandService.delete(brandId);
		model.addAttribute("message", "the brand was deleted");
		return new ModelAndView("forward://WEB-INF/allBrands.jsp", "allBrands", brandService.retrieveAll());
	}
}
