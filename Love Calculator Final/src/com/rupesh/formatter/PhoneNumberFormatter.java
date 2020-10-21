package com.rupesh.formatter;

import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
import com.rupesh.model.Phone;

public class PhoneNumberFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone phoneObj, Locale locale) {
		return phoneObj.getCountryCode() + "-" + phoneObj.getUserNumber();
	}

	@Override
	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {
		Phone phone = new Phone();
		String[] splitNum = completePhoneNumber.split("-");
		int index = completePhoneNumber.indexOf("-");
		if (index == -1 || completePhoneNumber.startsWith("-")) {
			phone.setCountryCode("+977");
			if (completePhoneNumber.startsWith("-"))
				phone.setUserNumber(splitNum[1]);
			else
				phone.setUserNumber(splitNum[0]);
		} else {
			phone.setCountryCode(splitNum[0]);
			phone.setUserNumber(splitNum[1]);
		}
		return phone;
	}

}
