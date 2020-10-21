package com.rupesh.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rupesh.custom.validator.EmailValidator;
import com.rupesh.custom.validator.UsernameValidator;
import com.rupesh.model.CommunicationDto;
import com.rupesh.model.Phone;
import com.rupesh.model.UserRegistrationDto;

@Controller
public class RegistrationController {

	@RequestMapping(value = "/register")
	public String register(@ModelAttribute("userReg") UserRegistrationDto userReg) {
		// TODO load the user data from the data base
		Phone phone = new Phone();
		phone.setCountryCode("+977");
		phone.setUserNumber("1122334455");
		CommunicationDto cDto = new CommunicationDto();
		cDto.setPhone(phone);
		userReg.setCommunicationDto(cDto);

		return "register-user";
	}

	@RequestMapping(value = "/registration-success", method = RequestMethod.POST)
	public String registrationSuccess(@Valid @ModelAttribute("userReg") UserRegistrationDto userReg,
			BindingResult result) {
		
		//calling email validator manually
//		EmailValidator emailValidator = new EmailValidator();
//		emailValidator.validate(userReg, result);
		
		
		if (result.hasErrors()) {
			return "register-user";
		}
		return "registration-success";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// binder.setDisallowedFields("communicationDto.email");1458

		//Property editor
		//Trimming WhiteSpace in text field of name
		binder.registerCustomEditor(String.class, "name", new StringTrimmerEditor(false));
		
		//adding custom spring validator for user name field
		binder.addValidators(new UsernameValidator());
		
		//adding custom spring validator for email field
		binder.addValidators(new EmailValidator());
	}
}
