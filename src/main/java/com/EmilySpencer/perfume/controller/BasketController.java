package com.EmilySpencer.perfume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.EmilySpencer.perfume.model.Basket;
import com.EmilySpencer.perfume.model.User;
import com.EmilySpencer.perfume.service.BasketService;
import com.EmilySpencer.perfume.service.UserService;

@RestController
public class BasketController {

	@Autowired
	private BasketService basketService;

	@Autowired
	private UserService userService;

	@GetMapping("/Basket/{userId}")
	public ModelAndView basket(@PathVariable("userId") Long userId, Model model) {
		model.addAttribute("user", userService.findAUser(userId).get());
		User user = userService.findAUser(userId).get();
		Basket basket = basketService.getByUser(user);
		return new ModelAndView("../WEB-INF/allPerfumesInBasket.jsp", "allPerfumesInBasket",
				basketService.getBasketsPerfumes(basket));
	}
}
