package com.EmilySpencer.perfume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.EmilySpencer.perfume.model.Store;
import com.EmilySpencer.perfume.service.StoreService;

@Controller
public class StoreController {

	@Autowired
	private StoreService storeService;

	private static final Logger LOGGER = LogManager.getLogger(StoreController.class);

	@GetMapping("/AllStores")
	public ModelAndView allStores() {
		return new ModelAndView("WEB-INF/allStores.jsp", "allStores", storeService.retrieveAll());
	}

	@GetMapping("/AllStoresCustomer")
	public ModelAndView allStoresCustomer() {
		return new ModelAndView("WEB-INF/allStoresCustomer.jsp", "allStores", storeService.retrieveAll());
	}

	@GetMapping("/AddStore")
	public String addStore() {
		return "WEB-INF/addStore.jsp";
	}

	@PostMapping("/AddStoreSubmit")
	public ModelAndView addAuthorSubmit(Store store, ModelMap model) {
		storeService.create(store);
		LOGGER.info("Store " + store + "has been added");
		model.addAttribute("message", "Store" + store.getLocation() + "has been added");
		return new ModelAndView("WEB-INF/allStores.jsp", "allStores", storeService.retrieveAll());
	}

}
