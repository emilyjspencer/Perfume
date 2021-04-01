package com.EmilySpencer.perfume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.EmilySpencer.perfume.service.StoreService;

@Controller
public class StoreController {

	@Autowired
	private StoreService storeService;

	@GetMapping("/AllStores")
	public ModelAndView allStores() {
		return new ModelAndView("WEB-INF/allStores.jsp", "allStores", storeService.retrieveAll());
	}

}
