package com.rupesh.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserInfoDto {

	@NotEmpty(message="{field.notEmpty}")
	@Size(min = 3, max = 15, message = "{field.size}")
	private String yourName;
	
	@NotEmpty(message="{field.notEmpty}")
	@Size(min = 3, max = 15, message = "{field.size}")
	private String crushName;
	
	@AssertTrue(message="{field.term}")
	private boolean term;

	public String getYourName() {
		return yourName;
	}

	public void setYourName(String yourName) {
		this.yourName = yourName;
	}

	public String getCrushName() {
		return crushName;
	}

	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}

	public boolean isTerm() {
		return term;
	}

	public void setTerm(boolean term) {
		this.term = term;
	}

}
