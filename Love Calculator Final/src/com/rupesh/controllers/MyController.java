package com.rupesh.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rupesh.model.UserInfoDto;

@Controller
public class MyController {
	
	@RequestMapping(value = {"/","/home"})
	public String home(@ModelAttribute("userInfo") UserInfoDto userInfo) {
		return "home";
	}
	
	@RequestMapping("/calculate")
	public String calculate(@Valid @ModelAttribute("userInfo") UserInfoDto userInfo, BindingResult result) {
		if(result.hasErrors()) {
			return "home";
		}
		return "calculate";
	}
	
}
