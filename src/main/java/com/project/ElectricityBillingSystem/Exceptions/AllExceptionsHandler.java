package com.project.ElectricityBillingSystem.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.FieldError;

@ControllerAdvice
public class AllExceptionsHandler {
	
	@ExceptionHandler({
		
		LoginInvalidCredentialsExceptions.class,
		
		
	})
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	
	
	@ExceptionHandler({
			AddressNotFoundException.class,
			AdminNotFoundException.class,
			BillingNotFoundException.class,
			CustomerNotFoundException.class,
			LoginNotFoundException.class,
			PaymentNotFoundException.class,
			ServiceNotFoundException.class
	})
	public Map<String, String> handleAddressNotFoundException(Exception ex) {
		System.out.println("first");
	    Map<String, String> errors = new HashMap<>();
	    errors.put("Error", ex.toString());
	    errors.put("Message", ex.getMessage());
	    return errors;
	}
	
}
