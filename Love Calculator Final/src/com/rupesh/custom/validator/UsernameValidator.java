package com.rupesh.custom.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rupesh.model.UserRegistrationDto;

public class UsernameValidator implements Validator {

	//checks whether the UsernameValidator supports the given object
	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistrationDto.class.equals(clazz);
	}

	//Actual validation logics
	@Override
	public void validate(Object target, Errors errors) {
		// Checks if the field id empty
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.empty","* username can't be empty.");
		
		//checks for _ 
		String username = ((UserRegistrationDto)target).getUsername();
		if(!username.contains("_")) {
			errors.rejectValue("username", "username.invalidFormat","* username must contain a _");
		}

	}

}
