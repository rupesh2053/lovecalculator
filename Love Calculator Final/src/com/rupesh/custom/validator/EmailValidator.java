package com.rupesh.custom.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rupesh.model.UserRegistrationDto;

public class EmailValidator implements Validator {

	//checks whether the UsernameValidator supports the given object
	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistrationDto.class.equals(clazz);
	}

	//Actual validation logics
	@Override
	public void validate(Object target, Errors errors) {
		// Checks if the field id empty
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDto.email", "communicationDto.email.empty");
		
		//checks whether the given email is ending with seleniumexpress.com
		String email = ((UserRegistrationDto)target).getCommunicationDto().getEmail();
		if(!email.endsWith("seleniumexpress.com")) {
			errors.rejectValue("communicationDto.email", "communicationDto.email.invalid.format");
		}

	}

}
