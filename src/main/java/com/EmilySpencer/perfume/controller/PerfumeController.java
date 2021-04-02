package com.EmilySpencer.perfume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.EmilySpencer.perfume.model.Perfume;
import com.EmilySpencer.perfume.service.BrandService;
import com.EmilySpencer.perfume.service.PerfumeService;
import com.EmilySpencer.perfume.service.StoreService;

@Controller
public class PerfumeController {

	@Autowired
	private PerfumeService perfumeService;

	@Autowired
	private StoreService storeService;

	@Autowired
	private BrandService brandService;

	@GetMapping("/AllPerfumes")
	public ModelAndView allPerfumes() {
		return new ModelAndView("WEB-INF/allPerfumes.jsp", "allPerfumes", perfumeService.retrieveAll());
	}

	@GetMapping("/AllPerfumesCustomer")
	public ModelAndView allPerfumesCustomer() {
		return new ModelAndView("WEB-INF/allPerfumesCustomer.jsp", "allPerfumes", perfumeService.retrieveAll());
	}

	@GetMapping("/AddPerfume")
	public ModelAndView addPerfume() {
		ModelAndView model = new ModelAndView("WEB-INF/addPerfume.jsp");
		model.addObject("perfume", new Perfume());
		model.addObject("allStores", storeService.retrieveAll());
		model.addObject("allBrands", brandService.retrieveAll());
		return model;
	}

	@PostMapping("/AddPerfumeSubmit")
	public ModelAndView addPerfumeSubmit(Perfume perfume, ModelMap model) {
		perfumeService.create(perfume);
		model.addAttribute("message", "perfume " + perfume.getName() + " has been added");
		return new ModelAndView("WEB-INF/allPerfumes.jsp", "allPerfumes", perfumeService.retrieveAll());
	}

}
