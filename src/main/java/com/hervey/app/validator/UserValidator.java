package com.hervey.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.hervey.app.models.User;
@Component
public class UserValidator implements Validator {
	 
	@Override
	public boolean supports(Class<?> claszz) {
		return User.class.equals(claszz);
	}
	
	@Override
	//prevent non-confirmed passwords from registering
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(!user.getPasswordConfirmation().equals(user.getPassword())){
			System.out.println("the two passwords did not match");
			errors.rejectValue("passwordConfirmation", "Match");
		}
		else {
			System.out.println("the two passwords matched so good for registering");
		}
		
	}
	
	
	

}
