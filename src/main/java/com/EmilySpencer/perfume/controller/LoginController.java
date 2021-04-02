package com.EmilySpencer.perfume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.EmilySpencer.perfume.model.User;
import com.EmilySpencer.perfume.service.UserService;

public class LoginController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/Login")
	public String login() {
		return "login.jsp";
	}

	@PostMapping("/LoginSubmit")
	public ModelAndView loginSubmit(@ModelAttribute("user") User user) {
		User userFromDb = userService.getByUsernameAndPassword(user.getUsername(), user.getPassword());
		ModelAndView modelAndView = new ModelAndView();
		if (userFromDb == null) {
			modelAndView.addObject("message", "Details not found. Please try again");
			modelAndView.setViewName("Login.jsp");
			return modelAndView;
		}
		if (userService.checkIfAdmin(userFromDb)) {
			modelAndView.addObject("message", "Welcome " + userFromDb.getFirstName());
			modelAndView.addObject("userId", userFromDb.getUserId());
			modelAndView.setViewName("WEB-INF/main.jsp");
			return modelAndView;
		} else {
			modelAndView.addObject("message", "Welcome " + userFromDb.getFirstName());
			modelAndView.addObject("userId", userFromDb.getUserId());
			modelAndView.setViewName("WEB-INF/mainCustomer.jsp");
			return modelAndView;
		}
	}


}
