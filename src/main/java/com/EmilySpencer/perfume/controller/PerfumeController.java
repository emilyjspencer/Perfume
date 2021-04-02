package com.EmilySpencer.perfume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/EditPerfume/{perfumeId}")
	public ModelAndView editPerfume(@PathVariable("perfumeId") Long perfumeId, Model model) {
		model.addAttribute("perfume", perfumeService.retrieveOne(perfumeId).get());
		model.addAttribute("allBrands", brandService.retrieveAll());
		model.addAttribute("allStores", storeService.retrieveAll());
		return new ModelAndView("../WEB-INF/editPerfume.jsp", "perfume", perfumeService.retrieveOne(perfumeId));
	}

	@PostMapping("/EditPerfumeSubmit")
	public ModelAndView editPerfumeSubmit(@ModelAttribute("perfume") Perfume perfume, Model model) {
		perfumeService.update(perfume);
		model.addAttribute("message", "perfume " + perfume.getName() + " has been updated");
		return new ModelAndView("forward://WEB-INF/allPerfumes.jsp", "allPerfumes", perfumeService.retrieveAll());
	}
	
	@PostMapping(value = "/EditPerfumeSubmit", params = { "Delete=Delete" })
	public ModelAndView editPerfumeSubmit(Perfume perfume, Model model, Long perfumeId) {
		perfumeService.delete(perfumeId);
		model.addAttribute("message", "Perfume was deleted");
		return new ModelAndView("forward://WEB-INF/allPerfumes.jsp", "allPerfumes", perfumeService.retrieveAll());
	}
}
